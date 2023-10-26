package com.champion.handler;/**
 * @author Mr.Wang
 * @create 2023-10-07-17:42
 */

import com.alibaba.fastjson.JSON;
import com.champion.entity.ResponseResult;
import com.champion.utils.WebUtils;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *@ClassName AuthenticationEntryPointImpl
 *@Description TODO
 *@Author Mr.Wang
 *@Date 2023/10/7 17:42
 *@Version 1.0
 */
@Component
public class AccessDeniedHandlerImpl implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AccessDeniedException e) throws IOException, ServletException {
        ResponseResult result = new ResponseResult<>(HttpStatus.FORBIDDEN.value(),"您的权限不足");
        String json = JSON.toJSONString(result);
        //处理异常
        WebUtils.renderString(httpServletResponse,json);
    }
}


