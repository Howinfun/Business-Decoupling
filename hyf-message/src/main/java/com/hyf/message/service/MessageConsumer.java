package com.hyf.message.service;

import com.alibaba.fastjson.JSON;
import com.hyf.encapsulation.constants.UserConstants;
import com.hyf.encapsulation.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * @author Howinfun
 * @desc
 * @date 2019/5/16
 */
@Component
public class MessageConsumer {

    @Autowired
    private MessageService messageService;

    @JmsListener(destination = UserConstants.USER_REGISTER,containerFactory = "jmsTopicListenerContainerFactory")
    public void consumeMessage(String textMsg){
        User user = JSON.parseObject((String) textMsg, User.class);
        // 发送短信的业务逻辑
        messageService.sendMessage(user);
    }
}
