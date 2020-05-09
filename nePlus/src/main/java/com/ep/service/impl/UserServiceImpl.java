package com.ep.service.impl;

import com.ep.model.entity.User;
import com.ep.mapper.UserMapper;
import com.ep.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Date: 2020/4/8 16:01
 * @Description:
 **/
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    /**
     * 根据id查询
     *
     * @param userId
     * @return
     */
    @Override
    public User selectById(String userId) {
        return userMapper.selectByPrimaryKey(userId);
    }

    /**
     * 更新用户
     *
     * @param user
     */
    @Override
    public int update(User user) {
        return userMapper.updateByPrimaryKeySelective(user);
    }

    /**
     * 删除用户
     *
     * @param userId
     */
    @Override
    public int delete(String userId) {
        return userMapper.deleteByPrimaryKey(userId);
    }

    /**
     * 新增用户
     *
     * @param user
     */
    @Override
    public int insert(User user) {
        return userMapper.insertSelective(user);
    }

    /**
     * 查询用户列表
     *
     * @param nameParam
     * @return
     */
    @Override
    public List<User> userList(String nameParam) {
        return userMapper.userList(nameParam);
    }

    @Override
    public int checkName(String username) {
        return userMapper.checkName(username);
    }
}
