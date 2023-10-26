package com.champion.controller;/**
 * @author Mr.Wang
 * @create 2023-10-06-17:48
 */

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *@ClassName HelloController
 *@Description TODO
 *@Author Mr.Wang
 *@Date 2023/10/6 17:48
 *@Version 1.0
 */
@RestController
public class HelloController {
    @GetMapping("/hello")
    @PreAuthorize("@ex.hasAuthority('system:dept:list')")
//    @PreAuthorize("hasAuthority('system:dept:list1')")//访问时所需要的权限
//    @PreAuthorize("hasAnyAuthority('test','admin','system:dept:list')")//只要满足其中的任意一个就可以满足
//    @PreAuthorize("hasRole('system:dept:list')")//我们传入的参数拼接上 ROLE_ 后再去比较
//    @PreAuthorize("hasAnyRole('admin','system:dept:list')")//它内部也会把我们传入的参数拼接上 ROLE_ 后再去比较
    public String hello(){
        return "hello";
    }

}


