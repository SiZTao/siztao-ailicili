package com.siztao.service.sys;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.siztao.ailicili.service.manage.api.sys.ApplicationService;
import com.siztao.ailicili.service.manage.entity.sys.Application;
import com.siztao.test.base.BaseTest;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * MyBatis操作演示
 */
public class ApplicationServiceTest extends BaseTest{
    private static Logger LOG = LoggerFactory.getLogger(ApplicationServiceTest.class);

    @Autowired
    ApplicationService  applicationService;

    @Test
    public void testSelectList(){
        LOG.info("第一次查询");
        List<Application>   apps = applicationService.selectList(null);
        LOG.info("list:{}", JSON.toJSON(apps));
        LOG.info("第二次查询");
        List<Application>   apps2 = applicationService.selectList(null);
        LOG.info("list:{}", JSON.toJSON(apps2));
    }
    @Test
    public void testPage(){
            Page<Application>   pager = applicationService.selectPage(new Page<Application>(1,10),new EntityWrapper<Application>());
            LOG.info("Page :{}"+ JSON.toJSON(pager));

    }
    @Test
    public void testActiveRecord(){
        boolean result = false;
        Application application = new Application();
        application.setName("CMS网站管理系统");
        application.setCode("CMS_SYS");
        application.setHref("www.siztao.cms.com");
        application.setTitle("内容管理系统");
        result = application.insert();
    }
    @Test
    public void testAppListByUID(){
        List<Application>   list = applicationService.selectAppListByUID(0);
        LOG.info("AppList:{}",JSON.toJSON(list));
    }
    //添加应用
    @Test
    public void testAppInsert(){

    }
    @Test
    public void testAppEdit(){

    }
    @Test
    public void testAppDelete(){

    }
    @Test
    public void testAppQuery(){

    }
}
