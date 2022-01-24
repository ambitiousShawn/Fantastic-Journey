package com.cloudnote.controller;


import com.cloudnote.pojo.User;
import com.cloudnote.service.UserService;
import com.cloudnote.vo.ResultInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import javax.annotation.Resource;

@RestController
@RequestMapping("/user")
@Api(tags = "用户模块功能接口")
public class UserController {

    @Resource
    private UserService userService;

    @PostMapping("/login")
    @ApiOperation("用户登录")
    @ApiImplicitParams({@ApiImplicitParam(name = "userName",value = "用户名",required = true),
                        @ApiImplicitParam(name = "password",value = "密码",required = true)})
    public ResultInfo<User> login(String userName,String password){
        return userService.checkLogin(userName,password);
    }

    @PostMapping("/register")
    @ApiOperation("用户注册")
    public ResultInfo<User> register(User user){
        String userName = user.getUserName();
        String password = user.getPassword();
        String nick = user.getNick();
        return userService.checkRegister(userName,password,nick);
    }

    @PostMapping("/updatePwd")
    @ApiOperation("修改密码")
    @ApiImplicitParam(name = "newPwd",value = "新密码",required = true)
    public ResultInfo<User> updatePwd(User user,String newPwd){
        return userService.updatePwd(user,newPwd);
    }
}
