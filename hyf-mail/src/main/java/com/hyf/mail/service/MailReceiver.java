package com.hyf.mail.service;

import com.alibaba.fastjson.JSON;
import com.hyf.encapsulation.entity.User;
import com.hyf.encapsulation.inter.AbstractReceiver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Howinfun
 * @desc
 * @date 2019/5/14
 */
@Component
public class MailReceiver implements AbstractReceiver {
    @Autowired
    private MailService mailService;
    @Override
    public void receiveMessage(Object message) {
        User user = JSON.parseObject((String) message, User.class);
        // 发动邮件的业务逻辑
        mailService.sendEMail(user);
    }
}
