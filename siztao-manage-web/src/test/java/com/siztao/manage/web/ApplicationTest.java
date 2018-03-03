package com.siztao.manage.web;

import com.siztao.ailicili.manage.web.controller.sys.ApplicationController;
import com.siztao.ailicili.service.manage.api.sys.ApplicationService;
import com.siztao.ailicili.service.manage.entity.sys.Application;
import com.siztao.manage.base.BaseJunitTest;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/spring/spring-context.xml","classpath:/springmvc/spring-mvc.xml"})
@WebAppConfiguration
public class ApplicationTest extends BaseJunitTest{
    @Autowired
    private WebApplicationContext wac;
    private MockMvc mockMvc;
    @Mock
    ApplicationService  applicationService;
    @InjectMocks
    private ApplicationController   applicationController;

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(applicationController).build();
    }

    @Test
    public void test()throws Exception{

    }
}
