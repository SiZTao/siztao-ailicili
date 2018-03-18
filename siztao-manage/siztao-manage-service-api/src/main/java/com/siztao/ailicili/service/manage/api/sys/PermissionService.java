package com.siztao.ailicili.service.manage.api.sys;

import com.baomidou.mybatisplus.service.IService;
import com.siztao.ailicili.service.manage.entity.sys.Dept;
import com.siztao.ailicili.service.manage.entity.sys.Permission;
import com.siztao.framework.model.AjaxResult;
import com.siztao.framework.model.ZtreeVo;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author SiZhenTao
 * @since 2018-03-02
 */
public interface PermissionService extends IService<Permission> {

    //根据父菜单，查询所有子菜单
    List<Permission>   queryListParentId(Integer parentId,List<Integer> menuIdList,Integer appId);

    //获取不包含按钮的菜单列表
    List<Permission>   queryNotButtonList();

    //获取用户菜单列表

    List<Permission>   getUserMenuList(Integer userId,Integer appId);

    //查询权限数据
    List<Permission>   listPermissionWithUID(Map<String,Object> queryMap);
    //获取菜单列表

    List<ZtreeVo>      selectPermissionWithZtree(boolean isShowTopParent,List<Permission> vos);



    /**
     * 单表操作
     */
    AjaxResult  savePermission(Permission permission);

    AjaxResult  updatePermission(Permission permission);

    AjaxResult  delete(Integer permissionId);

    AjaxResult  queryPermission(Permission permission);
}
