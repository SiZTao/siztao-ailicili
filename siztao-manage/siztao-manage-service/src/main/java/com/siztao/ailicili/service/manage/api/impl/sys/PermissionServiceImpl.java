package com.siztao.ailicili.service.manage.api.impl.sys;


import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.siztao.ailicili.service.manage.api.sys.PermissionService;
import com.siztao.ailicili.service.manage.api.sys.UserService;
import com.siztao.ailicili.service.manage.dao.sys.PermissionMapper;
import com.siztao.ailicili.service.manage.dao.sys.UserMapper;
import com.siztao.ailicili.service.manage.entity.sys.Dept;
import com.siztao.ailicili.service.manage.entity.sys.Permission;
import com.siztao.framework.constants.GlobalConstants;
import com.siztao.framework.model.AjaxResult;
import com.siztao.framework.model.ZtreeVo;
import com.siztao.framework.utils.CollectionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author SiZhenTao
 * @since 2018-03-02
 */
@Service
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission> implements PermissionService {
    @Autowired  private PermissionMapper    permissionMapper;
    @Autowired  private UserService userService;


    @Override
    public List<Permission> queryListParentId(Integer parentId, List<Integer> menuIdListddd, Integer appId) {
        Map<String,Object> queryMap = new HashMap<String,Object>();
        queryMap.put("parentId",parentId);
        if(appId!=null){
            queryMap.put("appId",appId);
        }
        List<Permission>    menuList = permissionMapper.queryListParentId(queryMap);
        if(menuList == null){
            return menuList;
        }
        List<Permission>    userMenuList = new ArrayList<>();
        for (Permission menu:menuList){
            userMenuList.add(menu);
        }
        return userMenuList;
    }

    @Override
    public List<Permission> queryNotButtonList() {

        return permissionMapper.queryNotButtonList();
    }

    @Override
    public List<Permission> getUserMenuList(Integer userId, Integer appId) {
        //系统管理员,拥有最高权限
        if(userId==GlobalConstants.SUPER_ADMIN){
            return getAllMenuList(null,appId);
        }
        List<Integer>   menuIdList =    userService.queryAllMenuId(userId);
        return  getAllMenuList(menuIdList,appId);
    }

    @Override
    public List<Permission> listPermissionWithUID(Map<String, Object> queryMap) {
        return permissionMapper.listPermissionWithUID(queryMap);
    }

    @Override
    public List<ZtreeVo> selectPermissionWithZtree(boolean isShowTopParent, List<Permission> vos) {
        List<ZtreeVo>   results = new ArrayList<ZtreeVo>();
        if (isShowTopParent){
            ZtreeVo result = new ZtreeVo();
            result.setId("0");
            result.setpId("-1");
            result.setName("全部");
            results.add(result);
        }
        if(CollectionUtil.isNotEmpty(vos)){
            for(Permission per:vos){
                ZtreeVo foo = new ZtreeVo();
                foo.setId(String.valueOf(per.getId()));
                foo.setpId(String.valueOf(per.getParentid()));
                foo.setName(per.getName());
                results.add(foo);
            }
        }
        return results;
    }


    private List<Permission> getAllMenuList(List<Integer> menuIdList,Integer appId){
        //查询根菜单列表
        List<Permission> menuList = queryListParentId(0,menuIdList,appId);
        getMenuTreeList(menuList,menuIdList,appId);
        return menuList;

    }
    private List<Permission>    getMenuTreeList(List<Permission> menuList,List<Integer> menuIdList,Integer appId){
        List<Permission>    subMenuList =new ArrayList<>();
        for (Permission entity:menuList){
            if(entity.getType()== GlobalConstants.MenuType.CATALOG.getValue()){
                entity.setList(getMenuTreeList(queryListParentId(entity.getId(),menuIdList,appId),menuIdList,appId));
            }
            subMenuList.add(entity);
        }
        return subMenuList;
    }

    @Override
    public AjaxResult savePermission(Permission permission) {
        return null;
    }

    @Override
    public AjaxResult updatePermission(Permission permission) {
        return null;
    }

    @Override
    public AjaxResult delete(Integer permissionId) {
        return null;
    }

    @Override
    public AjaxResult queryPermission(Permission permission) {
        return null;
    }
}
