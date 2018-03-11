package com.siztao.ailicili.service;


import com.siztao.framework.utils.SpringContextUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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
            LOG.error("[sio-manage-service ] == application start error",e);
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
