package com.cest.dao;

import com.cest.pojo.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {

    List<User> queryList();
}