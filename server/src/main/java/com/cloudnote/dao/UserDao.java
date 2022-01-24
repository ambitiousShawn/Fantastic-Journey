package com.cloudnote.dao;

import com.cloudnote.pojo.User;

public interface UserDao {

    //根据用户名查找用户
    User queryUserByName(String userName);

    //注册账户
    int register(User user);

    //修改账户密码
    int updatePwd(User user);
}
