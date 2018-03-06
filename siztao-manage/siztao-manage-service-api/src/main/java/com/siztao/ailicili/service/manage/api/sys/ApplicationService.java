package com.siztao.ailicili.service.manage.api.sys;

import com.baomidou.mybatisplus.service.IService;
import com.siztao.ailicili.service.manage.entity.sys.Application;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author SiZhenTao
 * @since 2018-03-02
 */
public interface ApplicationService extends IService<Application> {
	List<Application>   selectAppListByUID(@Param("userId") Integer userId);     //根据用户权限查询应用
}
