package com.siztao.service.sys;

import com.alibaba.fastjson.JSON;
import com.siztao.ailicili.service.manage.api.sys.ApplicationService;
import com.siztao.ailicili.service.manage.entity.sys.Application;
import com.siztao.test.base.BaseTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ApplicationServiceTest extends BaseTest{
    private static Logger LOG = LoggerFactory.getLogger(ApplicationServiceTest.class);

    @Autowired
    ApplicationService  applicationService;

    @Test
    public void testSelectList(){
        List<Application>   apps = applicationService.selectList(null);
        LOG.info("list:{}", JSON.toJSON(apps));
    }
}
