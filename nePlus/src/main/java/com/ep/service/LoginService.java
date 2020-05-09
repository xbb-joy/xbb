package com.ep.service;

import com.ep.model.param.LoginParam;
import com.ep.model.entity.User;

/**
 * @Date: 2020/4/7 23:11
 * @Description:
 **/
public interface LoginService {
    User checkLogin(LoginParam param);

    int registerUser(User user);
}
