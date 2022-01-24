package com.cloudnote.service;

import com.cloudnote.pojo.User;
import com.cloudnote.vo.ResultInfo;

public interface UserService {

    //根据用户名查找用户对象
    User queryUserByName(String userName);

    //检查用户名是否合法且存在
    ResultInfo <User> checkLogin(String userName,String password);

    //检查注册账户是否合法且存在
    ResultInfo<User> checkRegister(String userName,String password,String nick);

    //修改密码
    ResultInfo<User> updatePwd(User user,String newPwd);
}
