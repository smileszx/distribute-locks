package com.victor.cache.dao;

import com.victor.cache.po.User;
import com.victor.cache.util.MyMapper;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper extends MyMapper<User> {
}