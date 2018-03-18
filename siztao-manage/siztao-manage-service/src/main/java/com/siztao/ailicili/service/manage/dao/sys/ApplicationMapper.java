package com.siztao.ailicili.service.manage.dao.sys;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.siztao.ailicili.service.manage.entity.sys.Application;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
  *  Mapper 接口
 * </p>
 *
 * @author SiZhenTao
 * @since 2018-03-02
 */
@Repository
public interface ApplicationMapper extends BaseMapper<Application> {
    List<Application>   selectAppListByUID(Integer  userId);
}