package com.siztao.ailicili.service.manage.api.impl.sys;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.siztao.ailicili.service.manage.api.sys.RoleService;
import com.siztao.ailicili.service.manage.dao.sys.RoleMapper;
import com.siztao.ailicili.service.manage.entity.sys.Role;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author SiZhenTao
 * @since 2018-03-02
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {

    @Override
    public List<Role> listRoleByUserId(Integer userId) {
        return null;
    }
}
