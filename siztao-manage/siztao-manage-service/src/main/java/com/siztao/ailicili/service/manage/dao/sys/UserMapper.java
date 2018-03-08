package com.siztao.ailicili.service.manage.dao.sys;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.siztao.ailicili.service.manage.entity.sys.User;

import java.util.List;

/**
 * <p>
  *  Mapper 接口
 * </p>
 *
 * @author SiZhenTao
 * @since 2018-03-02
 */
public interface UserMapper extends BaseMapper<User> {
    List<String>    queryAllPerms(Integer   userId);
    List<Integer>   queryAllMenuId(Integer  userId);
}