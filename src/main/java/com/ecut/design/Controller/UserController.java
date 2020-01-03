package com.ecut.design.Controller;

import com.ecut.design.Config.PasswordHelper;

import com.ecut.design.Model.User;
import com.ecut.design.Service.UserService;
import com.fasterxml.jackson.databind.util.JSONPObject;
import io.netty.util.internal.StringUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.spring.web.json.Json;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;


@RestController
@Api(value = "用户模块 UserController" ,tags = {"用户模块" })
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private PasswordHelper passwordHelper;

    @ApiOperation(value="账号密码登录",notes="账号密码登录")
    @PostMapping("/doLogin")
    public Object login(@ApiParam(value="用户名") @RequestParam(value = "username") String username,
                        @ApiParam(value="密码") @RequestParam(value = "password") String password){

        return userService.login (username,password);
    }

    @ApiOperation(notes="注册",value ="注册")
    @PostMapping("/register")
    public String register(@RequestBody @Param ("user") User user) {
        return userService.regist (user);
    }

    @ApiOperation(notes="发送验证码",value ="发送验证码")
    @PostMapping("/sendCaptcha")
    public String sendCaptcha(String phone){

     return userService.sendCaptcha (phone);
    }

    @ApiOperation(notes="手机验证码登录",value ="手机验证码登录")
    @PostMapping("/phoneLogin")
    public String loginByPhone(String phone,String captcha) {

        return userService.loginByPhone (phone,captcha);
    }

    @ApiOperation(notes="注销",value ="注销")
    @PostMapping("/loginOut")
    public String loginOut(){

        return userService.loginOut ();
    }


    @ApiOperation(notes="更新用户信息",value ="更新用户信息")
    @PutMapping("/updateUser")
    //注意swgger在遍历这个User的时候会出现stackOverflow
     public String update(@RequestBody User user){

        return userService.update (user);
     }



    @ApiOperation(notes="删除用户",value ="删除用户")
    @DeleteMapping("/deleteUser")
    public String deleteUsers(@RequestParam("ids") Long[] ids){

        return userService.deleteUsers (ids);
    }

    @ApiOperation(notes="更新用户状态",value ="更新用户状态")
    @PutMapping("/updateUserStatus")
    //注意swgger在遍历这个User的时候会出现stackOverflow
    public String updateUserStatus(@RequestParam("ids")Long[] ids, @RequestParam("status") String starus){

     return updateUserStatus (ids, starus);
    }

    @ApiOperation (value = "查询用户",notes = "查村用户")
    @GetMapping("/searchUsers")
    public Page<User> searchUsers(@RequestBody User user){

        return userService.searchUsers (user);
    }



}
