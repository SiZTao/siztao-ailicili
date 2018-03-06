package com.siztao.ailicili.service.manage.api.impl.sys;


import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.siztao.ailicili.service.manage.api.sys.UserService;
import com.siztao.ailicili.service.manage.dao.sys.UserMapper;
import com.siztao.ailicili.service.manage.entity.sys.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	
}
