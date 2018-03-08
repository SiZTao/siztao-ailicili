package com.siztao.ailicili.service.manage.api.sys;

import com.baomidou.mybatisplus.service.IService;
import com.siztao.ailicili.service.manage.entity.sys.User;
import com.siztao.framework.model.AjaxResult;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author SiZhenTao
 * @since 2018-03-02
 */
public interface UserService extends IService<User> {
    /**
     * 查询用户所有权限
     */
    List<String>  queryAllPerms(Integer userId);

    //查询用户所有菜单ID
    List<Integer> queryAllMenuId(Integer userId);

    AjaxResult    queryByAccount(String account);

    AjaxResult    queryObject(Integer userId);

    AjaxResult    updatePassword(Integer userId,String password,String newPassword);
}
