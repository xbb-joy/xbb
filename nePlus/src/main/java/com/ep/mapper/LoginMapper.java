package com.ep.mapper;

import com.ep.model.param.LoginParam;
import com.ep.model.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 *
 * @Date: 2020/4/7 23:13
 * @Description:
 **/
@Mapper
public interface LoginMapper {
    User checkLogin(LoginParam param);
}
