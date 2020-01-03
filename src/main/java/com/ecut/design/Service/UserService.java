package com.ecut.design.Service;

import com.ecut.design.Model.User;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;

import java.util.List;

public interface UserService {



    @ApiOperation ("登录")
    public String login (String username ,String password);

    @ApiOperation ("注册")
    public String regist(User user);

    @ApiOperation ("发送验证码")
    public String sendCaptcha(String phone);

    @ApiOperation ("手机号登录")
    public String loginByPhone(String phone,String captcha);

    @ApiOperation ("注销")
    public String loginOut();

    @ApiOperation ("更新用户信息")
    public String update(User user);

    @ApiOperation ("删除用户")
    public String deleteUsers(Long[] ids);

    @ApiOperation ("更新用户状态")
    public String updateUserStatus(Long[] ids,String status);

    @ApiOperation ("查询用户")
    public Page<User> searchUsers(User user);

}
