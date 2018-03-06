package com.siztao.ailicili.manage.web.shiro;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.siztao.ailicili.service.manage.api.sys.PermissionService;
import com.siztao.ailicili.service.manage.api.sys.RoleService;
import com.siztao.ailicili.service.manage.api.sys.UserService;
import com.siztao.ailicili.service.manage.entity.sys.Permission;
import com.siztao.ailicili.service.manage.entity.sys.User;
import com.siztao.framework.utils.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.subject.support.DefaultSubjectContext;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @项目名称: siztao-ailicili
 * @模块名称:
 * @类名称:
 * @类描述:
 * @创建人: SiZhenTao
 * @创建时间: 2018-03-04 21:09
 * @修改人: SiZhenTao
 * @修改时间: 2018-03-04 21:09
 * @email: 982637685@qq.com
 * @version:
 **/
@Service("globalAuthorizingRealm")
public class GlobalAuthorizingRealm extends AuthorizingRealm{

    private static final Logger LOG = LoggerFactory.getLogger(GlobalAuthorizingRealm.class);

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private PermissionService   permissionService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        User  user = (User) principalCollection.getPrimaryPrincipal();
        Integer userId = user.getId();
        List<String> permsList = null;
        //系统管理员 ,拥有最高权限
        if(userId == 0){
            //查出所有信息
            List<Permission>    menuList = permissionService.selectList(null);
            permsList = new ArrayList<>(menuList.size());
            for(Permission menu:menuList){
                permsList.add(menu.getPermission());
            }
        }else{
            //根据用户ID查询
        }
        //用户权限
        Set<String> permsSet = new HashSet<String>();
        for (String perms:permsList){
            if(StringUtils.isBlank(perms)){
                continue;
            }
            permsSet.addAll(Arrays.asList(perms.trim().split(",")));
        }
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.setStringPermissions(permsSet);
        return info;
    }

    /**
     * 登录认证
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken   upToken = (UsernamePasswordToken) authenticationToken;
        String account = upToken.getUsername();
        String  password = new String((char[]) upToken.getCredentials());

        if(StringUtils.isEmpty(account)){
            LOG.info("系统日志{}","login account is blank");
            throw new AccountException("Empty usernames are not allowed by this realm.");
        }
        //清除之前登录的Session 同一个账户只能在一个地方登录
//        DefaultWebSessionManager sessionManager = (DefaultWebSessionManager)securityManager.getSessionManager();
//        Collection<Session> sessions = sessionManager.getSessionDAO().getActiveSessions();//获取当前已登录的用户session列表
//        for(Session session:sessions){
//            //清除该用户以前登录时保存的session
//            if(acc.equals(String.valueOf(session.getAttribute(DefaultSubjectContext.PRINCIPALS_SESSION_KEY)))) {
//                sessionManager.getSessionDAO().delete(session);
//            }
//        }
        //根据用户名查询记录
        User    user;
        try {
            user = userService.selectOne(new EntityWrapper<User>().eq("account",account));
        }catch (Exception e) {
            e.printStackTrace();
            throw new AuthenticationException("cannot query user[" + account + "]", e);
        }
        if(user == null){
            final String errmsg = "No account found for user [" + account + "]";
            LOG.warn(errmsg);
            throw new UnknownAccountException("账户或密码不正确");
        }else if(!password.equals(user.getPassword())) {
            throw new IncorrectCredentialsException("账号或密码不正确");

        }else if(user.getStatus()== "1"){
            throw new LockedAccountException("用户 [" + account + "] 被锁定.");
        }else if(user.getStatus() == "2"){
            throw new DisabledAccountException("用户 [" + account + "] 被禁用");
        }else if(user.getStatus() == "-1"){
            throw new DisabledAccountException("用户 [" + account + "] 被删除");
        }

        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        session.setAttribute("CURRENT_USER",user);
        return new SimpleAuthenticationInfo(user, user.getPassword(), getName());
    }
}
