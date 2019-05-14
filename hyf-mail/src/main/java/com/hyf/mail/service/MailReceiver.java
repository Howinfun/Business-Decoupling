package com.hyf.mail.service;

import com.alibaba.fastjson.JSON;
import com.hyf.encapsulation.entity.User;
import com.hyf.encapsulation.inter.AbstractReceiver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author Howinfun
 * @desc
 * @date 2019/5/14
 */
@Slf4j
@Component
public class MailReceiver implements AbstractReceiver {
    @Override
    public void receiveMessage(Object message) {
        User user = JSON.parseObject((String) message, User.class);
        log.info("给用户"+user.getName()+"发送邮件，EMail为："+user.getMail());
    }
}
