package com.siztao.queue.service;

import com.siztao.queue.service.mq.MqSender;
import com.siztao.queue.service.task.SendTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class App {

    public static final String DEFAULT_CONFIG_LOCATION = "/spring-context.xml";

    @Autowired
    private MqSender mqSender;

    /**
     * 程序入口
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        ApplicationContext context = new ClassPathXmlApplicationContext(DEFAULT_CONFIG_LOCATION);
        App application = (App) context.getBean("app");
        application.run(args);
    }

    public void run(String[] args) {
        Thread thread = new Thread(new SendTask(mqSender));
        thread.start();
    }
}
