package com.ep.service.impl;

import com.ep.model.param.LoginParam;
import com.ep.model.entity.User;
import com.ep.mapper.LoginMapper;
import com.ep.mapper.UserMapper;
import com.ep.service.LoginService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Date: 2020/4/7 23:11
 * @Description:
 **/
@Service
public class LoginServiceImpl implements LoginService {

    @Resource
    private LoginMapper loginMapper;

    @Resource
    private UserMapper userMapper;

    @Override
    public User checkLogin(LoginParam param) {
        return loginMapper.checkLogin(param);
    }

    @Override
    public int registerUser(User user) {
        return userMapper.insertSelective(user);
    }
}
