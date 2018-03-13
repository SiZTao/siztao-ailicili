package com.siztao.queue.service.abstractClass;


import com.siztao.queue.service.model.MessageInfo;

import javax.jms.JMSException;

public abstract class AbstractMessageListener {
    public abstract void handleMessage(MessageInfo info) throws JMSException;
}