package com.cdl.demo.dao;

import com.cdl.demo.domain.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao {
    User queryUserById(Integer userId);
}
