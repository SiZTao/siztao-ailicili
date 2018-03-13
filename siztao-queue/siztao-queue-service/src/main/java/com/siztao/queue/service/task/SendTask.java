package com.siztao.queue.service.task;

import com.alibaba.fastjson.JSON;

import com.siztao.queue.service.model.MessageInfo;
import com.siztao.queue.service.mq.MqSender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SendTask implements Runnable {

    private static final Logger LOGGER = LoggerFactory.getLogger(SendTask.class);

    private MqSender sender;

    public SendTask(MqSender sender) {
        this.sender = sender;
    }

    @Override
    public void run() {
        int i=0;
        while (true) {
            try {
                MessageInfo info = new MessageInfo();
                i++;
                info.setUuid(i);
                info.setMsg("Ailicli对瓶吹");
                info.setAuthor("SiZhTao");
                LOGGER.info("插入一个任务到MQ, 任务信息为:" + JSON.toJSONString(info));
                sender.sendInfo(info);

                System.out.println("插入一个任务到MQ, 任务信息为:" + JSON.toJSONString(info));

                Thread.sleep(3000);
            } catch (Exception e) {
                LOGGER.error("TaskSearchTask任务出现未知错误", e);
            }
        }
    }

}
