package com.ep.mapper;

import com.ep.model.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Date: 2020/4/7 23:13
 * @Description:
 **/
@Mapper
public interface UserMapper extends tk.mybatis.mapper.common.Mapper<User> {
    List<User> userList(@Param("nameParam") String nameParam);

    int checkName(String username);
}
