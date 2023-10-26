package com.champion.controller;

import com.champion.entity.ResponseResult;

import com.champion.entity.User;
import com.champion.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : k
 * @Date : 2022/3/23
 * @Desc :
 */
@RestController
public class LoginController {
    @Autowired
    private LoginService loginService;

    @PostMapping("/user/login")
    public ResponseResult login(@RequestBody User user){

        return loginService.login(user);
    }

}
