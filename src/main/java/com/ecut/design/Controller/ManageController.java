package com.ecut.design.Controller;

import com.ecut.design.Model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("authc")
@Api(value = "管理员模块ManageController",tags = {"管理员模块"})
public class ManageController {

    @ApiOperation("首页")
    @GetMapping("index")
    public Object index() {
        Subject subject = SecurityUtils.getSubject();

        User user = (User) subject.getSession().getAttribute("user");
        System.out.println(subject.getSession());
        return "welcome";
    }
    @ApiOperation("管理员登录")
    @GetMapping("admin")
    public Object admin() {
        return "Welcome Admin";
    }


    @GetMapping("removable")
    public Object removable() {
        return "removable";
    }

    // insert & update
    @GetMapping("renewable")
    public Object renewable() {
        return "renewable";
    }
}