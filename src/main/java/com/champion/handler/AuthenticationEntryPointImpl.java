package com.champion.handler;

import com.alibaba.fastjson.JSON;
import com.champion.entity.ResponseResult;
import com.champion.utils.WebUtils;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *@ClassName AuthenticationEntryPoint
 *@Description TODO
 *@Author Mr.Wang
 *@Date 2023/10/7 17:32
 *@Version 1.0
 */
@Component
public class AuthenticationEntryPointImpl implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {

        ResponseResult result = new ResponseResult<>(HttpStatus.UNAUTHORIZED.value(),"用户认证失败，请重新登录");
        String json = JSON.toJSONString(result);
        //处理异常
        WebUtils.renderString(httpServletResponse,json);

    }
}


