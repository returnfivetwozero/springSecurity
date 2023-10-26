package com.champion.service;/**
 * @author Mr.Wang
 * @create 2023-10-06-15:48
 */

import com.champion.entity.ResponseResult;
import com.champion.entity.User;
import org.springframework.stereotype.Service;

/**
 *@ClassName LoginService
 *@Description TODO
 *@Author Mr.Wang
 *@Date 2023/10/6 15:48
 *@Version 1.0
 */

public interface  LoginService {
    ResponseResult login(User user);

    ResponseResult logout();
}


