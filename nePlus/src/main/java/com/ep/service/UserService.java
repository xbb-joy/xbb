package com.ep.service;

import com.ep.model.entity.User;

import java.util.List;

/**
 * @Date: 2020/4/8 16:01
 * @Description:
 **/
public interface UserService {
    User selectById(String userId);

    int update(User user);

    int delete(String userId);

    int insert(User user);

    int checkName(String username);

    List<User> userList(String nameParam);
}
