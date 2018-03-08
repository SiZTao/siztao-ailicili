package com.siztao.ailicili.service.manage.dao.sys;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.siztao.ailicili.service.manage.entity.sys.Permission;

import java.util.List;
import java.util.Map;

/**
 * <p>
  *  Mapper 接口
 * </p>
 *
 * @author SiZhenTao
 * @since 2018-03-02
 */
public interface PermissionMapper extends BaseMapper<Permission> {

    /**
     * 根据父菜单,查询子菜单
     * @param map
     * @return
     */
    List<Permission>    queryListParentId(Map<String,Object> map);

    /**
     * 查询不包含按钮的菜单列表
     * @return
     */
    List<Permission>    queryNotButtonList();

    /**
     * 查询用户权限列表
     * @param userId
     * @return
     */
    List<Permission>    queryUserList(Integer   userId);

    Integer queryMaxIdByParentId(Integer parentId);

}