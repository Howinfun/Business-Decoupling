package com.hyf.mail.service;

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
public class MailConsumer {

    @Autowired
    private MailService mailService;

    /**
     * 注意：这个是要启动一遍订阅了一次，才有之后的持久化订阅
     * @param textMsg
     */
    @JmsListener(destination = UserConstants.USER_REGISTER,containerFactory = "jmsTopicListenerContainerFactory")
    public void consumeMessage(String textMsg){
        User user = JSON.parseObject((String) textMsg, User.class);
        // 发送短信的业务逻辑
        mailService.sendEMail(user);
    }
}
