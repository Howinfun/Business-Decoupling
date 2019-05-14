package com.hyf.user.service;

import com.alibaba.fastjson.JSON;
import com.hyf.encapsulation.constants.UserConstants;
import com.hyf.encapsulation.entity.User;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

/**
 * @author Howinfun
 * @desc 用户Service
 * @date 2019/5/13
 */
@Service
@Slf4j
@AllArgsConstructor
public class UserService {

    private StringRedisTemplate stringRedisTemplate;

    /**
     * 用户注册
     * @param user
     */
    public void registerUser(User user){
        log.info("用户："+user.getName()+"注册成功");
        // 让redis的channel中发布消息
        String userInfo = JSON.toJSONString(user);
        stringRedisTemplate.convertAndSend(UserConstants.USER_REGISTER,userInfo);

    }
}
