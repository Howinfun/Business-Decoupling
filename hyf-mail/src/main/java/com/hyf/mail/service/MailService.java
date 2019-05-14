package com.hyf.mail.service;

import com.hyf.encapsulation.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author Howinfun
 * @desc 邮件Service
 * @date 2019/5/13
 */
@Service
@Slf4j
public class MailService {

    /**
     * 发送邮件
     * @param user
     */
    public void sendEMail(User user){
        log.info("给用户"+user.getName()+"发送邮件，EMail为："+user.getMail());
    }
}
