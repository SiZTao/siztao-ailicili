package com.siztao.ailicili.service.manage.api.impl.sys;


import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.siztao.ailicili.service.manage.api.sys.UserReRoleService;
import com.siztao.ailicili.service.manage.api.sys.UserService;
import com.siztao.ailicili.service.manage.dao.sys.UserMapper;
import com.siztao.ailicili.service.manage.entity.sys.User;
import com.siztao.framework.model.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 *  用户管理
 * </p>
 *
 * @author SiZhenTao
 * @since 2018-03-02
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private UserMapper  userMapper;
    @Autowired
    private UserReRoleService   userReRoleService;

    @Override
    public List<String> queryAllPerms(Integer userId) {
        return userMapper.queryAllPerms(userId);
    }

    @Override
    public List<Integer> queryAllMenuId(Integer userId) {
        return userMapper.queryAllMenuId(userId);
    }

    @Override
    public AjaxResult queryByAccount(String account) {
        return null;
    }

    @Override
    public AjaxResult queryObject(Integer userId) {
        return null;
    }

    @Override
    public AjaxResult updatePassword(Integer userId, String password, String newPassword) {
        return null;
    }
}
