package com.siztao.ailicili.service.manage.api.sys;

import com.baomidou.mybatisplus.service.IService;
import com.siztao.ailicili.service.manage.entity.sys.User;
import com.siztao.framework.model.AjaxResult;

import java.util.List;

/**
 * <p>
 *  管理员用户服务接口
 *      命名规范    Service
 *      获取单个对象        get 做前缀
 *      获取多个对象        list 做前缀
 *      获取统计值的方法    count做前缀
 *      插入的方法          save/insert做前缀
 *      删除的方法          remove/delete做前缀
 *      修改的方法          update做前缀
 *
 * </p>
 *      数据对象_DO     数据传输对象 DTO
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
