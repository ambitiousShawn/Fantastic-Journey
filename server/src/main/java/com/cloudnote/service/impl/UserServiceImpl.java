package com.cloudnote.service.impl;

import com.cloudnote.dao.UserDao;
import com.cloudnote.pojo.User;
import com.cloudnote.service.UserService;
import com.cloudnote.vo.ResultInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.LinkedList;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    @Override
    public User queryUserByName(String userName) {
        User user = userDao.queryUserByName(userName);
        return user;
    }

    @Override
    public ResultInfo <User> checkLogin(String userName,String password) {
        ResultInfo<User> ri = new ResultInfo <>();
        User user = queryUserByName(userName);
        ri.setCount(0);

        if (user == null){
            ri.setCode(8001);
            ri.setMsg("用户名不存在");
            return ri;
        }

        String userPwd = user.getPassword();
        if(!password.equals(userPwd)){
            ri.setCode(8002);
            ri.setMsg("密码不正确");
            return ri;
        }
        ri.setCode(1001);
        ri.setMsg("登录成功");
        ri.setCount(1);
        ri.getInfo().add(user);
        return ri;
    }

    @Override
    @Transactional
    public ResultInfo <User> checkRegister(String userName,String password,String nick) {
        ResultInfo<User> ri = new ResultInfo <>();
        ri.setCount(0);

        //长度限制
        if (userName.length()>16||userName.length()<6||
            password.length()>16||password.length()<6){
            ri.setCode(8001);
            ri.setMsg("用户名或密码长度应为6~16位");
            return ri;
        }
        //重复限制
        User u = queryUserByName(userName);
        if(u != null){
            ri.setCode(8002);
            ri.setMsg("该用户名已被注册");
            return ri;
        }

        //检测昵称长度
        if (nick.length()>12||nick.length()<1){
            ri.setCode(8003);
            ri.setMsg("昵称长度应为1~12位");
            return ri;
        }
        User user = new User();
        user.setUserName(userName);
        user.setPassword(password);
        user.setNick(nick);
        int rows = userDao.register(user);
        if (rows == 1){
            ri.setCode(1001);
            ri.setMsg("注册成功");
            ri.setCount(1);
            ri.getInfo().add(user);
            return ri;
        }
        ri.setCode(8005);
        ri.setMsg("系统繁忙，请稍后再试");
        return ri;
    }

    @Override
    @Transactional
    public ResultInfo <User> updatePwd(User user,String newPwd) {
        String userName = user.getUserName();
        String oldPwd = user.getPassword();
        ResultInfo<User> ri = checkLogin(userName,oldPwd);
        ri.setCount(0);
        ri.setInfo(new LinkedList <>());
        if(ri.getCode()==1001){
            //长度限制
            if(newPwd.length()>16||newPwd.length()<6){
                ri.setCode(8001);
                ri.setMsg("新密码长度应为6~16位");
                return ri;
            }
            user.setUserName(userName);
            user.setPassword(newPwd);
            int rows = userDao.updatePwd(user);
            if (rows == 1){
                ri.setCode(1001);
                ri.setMsg("修改密码成功");
                ri.setCount(1);
                ri.getInfo().add(user);
                return ri;
            }
            ri.setCode(8005);
            ri.setMsg("系统繁忙，请稍后再试");
            return ri;
        }
        ri.setCode(8002);
        ri.setMsg("原密码错误");
        return ri;
    }
}
