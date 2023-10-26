package com.champion.mapper;/**
 * @author Mr.Wang
 * @create 2023-10-06-19:01
 */

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.champion.entity.Menu;

import java.util.List;

/**
 *@InterfaceName MunuMapper
 *@Description TODO
 *@Author Mr.Wang
 *@Date 2023/10/6 19:01
 *@Version 1.0
 */
public interface MenuMapper extends BaseMapper<Menu> {
    List<String> selectPermsByUserId(Long userId);
}
