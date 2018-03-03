package com.siztao.ailicili.service;


import com.siztao.ailicili.service.util.SpringContextUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.xbean.spring.context.ClassPathXmlApplicationContext;

public class ManageApplicationStart {
    private static final Log LOG = LogFactory.getLog(ManageApplicationStart.class);

    public static void main(String[]args){
        try{
            ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"spring/spring-context.xml"});
            //初始化SpringContextUtil
            SpringContextUtil ctxUtil = new SpringContextUtil();
            ctxUtil.setApplicationContext(context);
            context.start();
            LOG.info("ManageService Dubbo Service == context start");
        }catch (Exception e){
            LOG.error("[sizto-manage-service ] == application start error",e);
            return;
        }
        synchronized (ManageApplicationStart.class){
            while (true){
                try{
                    ManageApplicationStart.class.wait();
                }catch (InterruptedException e){
                    LOG.error("== synchronized error:", e);
                }
            }
        }
    }
}
