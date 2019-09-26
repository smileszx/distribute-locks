package com.victor.cache.service;

import com.victor.cache.po.User;

import java.util.List;

/**
 * @Description
 * 用户信息接口
 * @Author victor su
 * @Date 2019/9/26 11:14
 **/
public interface UserService {

    /**
     * 新增用户
     * @param user
     * @return
     */
    String addUser(User user);

    /**
     * 主键id查询用户信息
     * @param id
     * @return
     */
    User findUserById (Integer id);

    /**
     * 查询所有用户信息
     * @return
     */
    List<User> findUserList();

}
