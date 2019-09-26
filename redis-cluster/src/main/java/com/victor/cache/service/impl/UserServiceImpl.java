package com.victor.cache.service.impl;

import com.victor.cache.annotation.RedisCache;
import com.victor.cache.dao.UserMapper;
import com.victor.cache.po.User;
import com.victor.cache.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description
 * 用户信息接口实现类
 * @Author victor su
 * @Date 2019/9/26 11:15
 **/
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public String addUser(User user) {
        return userMapper.insert(user) +"";
    }

    @Override
    @RedisCache(type = User.class)
    public User findUserById(Integer id) {
        User user = userMapper.selectByPrimaryKey(id);
        return user;
    }

    @Override
    @RedisCache(type = User.class)
    public List<User> findUserList() {
        return userMapper.selectAll();
    }
}
