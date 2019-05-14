package com.hyf.user.controller;

import com.hyf.encapsulation.entity.User;
import com.hyf.user.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Howinfun
 * @desc
 * @date 2019/5/13
 */
@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {
    private UserService userService;

    @PostMapping(value = "/registerUser",consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String registerUser(@RequestBody User user){
        userService.registerUser(user);
        return "注册成功";
    }
}
