package com.siztao.ailicili.service.manage.api.impl.sys;


import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.siztao.ailicili.service.manage.api.sys.ApplicationService;
import com.siztao.ailicili.service.manage.dao.sys.ApplicationMapper;
import com.siztao.ailicili.service.manage.entity.sys.Application;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author SiZhenTao
 * @since 2018-03-02
 */
@Service("applicationServiceImpl")
public class ApplicationServiceImpl extends ServiceImpl<ApplicationMapper, Application> implements ApplicationService {
	
}
