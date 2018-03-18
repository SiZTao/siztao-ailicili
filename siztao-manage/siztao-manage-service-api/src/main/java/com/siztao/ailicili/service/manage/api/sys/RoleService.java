package com.siztao.ailicili.service.manage.api.sys;

import com.baomidou.mybatisplus.service.IService;
import com.siztao.ailicili.service.manage.entity.sys.Role;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author SiZhenTao
 * @since 2018-03-02
 */
public interface RoleService extends IService<Role> {
    /**
     * 通过用户ID查询 角色
     * @param userId
     * @return
     */
	public List<Role>   listRoleByUserId(Integer    userId);
}
