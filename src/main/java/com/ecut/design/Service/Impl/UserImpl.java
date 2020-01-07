package com.ecut.design.Service.Impl;

import com.ecut.design.Config.PasswordHelper;
import com.ecut.design.Config.util.CodeUtil;
import com.ecut.design.Config.util.PageableUtil;
import com.ecut.design.Config.util.SnowFlake;
import com.ecut.design.Model.User;
import com.ecut.design.Repository.UserRepository;
import com.ecut.design.Service.UserService;
import io.netty.util.internal.StringUtil;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UserImpl implements UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    private PasswordHelper passwordHelper;
    @Autowired
    private PageableUtil pageableUtil;

    private static final transient Logger log = LoggerFactory.getLogger(UserImpl.class);   // 获取当前的 Subject. 调用 SecurityUtils.getSubject();


    @ApiOperation("登录")
    @Override
    public String login (String username, String password) {
         Subject currentUser = SecurityUtils.getSubject ();

        // 测试当前的用户是否已经被认证. 即是否已经登录.
        // 调动 Subject 的 isAuthenticated()
        Session session = currentUser.getSession();//获取session
        session.setAttribute("someKey", "aValue");//在session中设置值
        String value = (String) session.getAttribute("someKey");//从session中获取值
        if (value.equals("aValue")) {
            log.info("Retrieved the correct value! [" + value + "]");
            //return;
        }
        if (!currentUser.isAuthenticated ()) {
            // 把用户名和密码封装为 UsernamePasswordToken 对象
            UsernamePasswordToken token = new UsernamePasswordToken (username, password);
            // rememberme
            token.setRememberMe (true);
            try {
                /*System.out.println ("hashCode:" + token.hashCode ());
                System.out.println ("Principal:" + token.getPrincipal ());
                System.out.println ("Credentials:" + String.valueOf ((char[]) token.getCredentials ()));
                System.out.println ("host:" + token.getHost ());
                System.out.println ("Username:" + token.getUsername ());
                System.out.println ("Password:" + String.valueOf (token.getPassword ()));*/
                // 执行登录.
                currentUser.login (token);
                SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
                User user =userRepository.findByUsername (username);
                SecurityUtils.getSubject().getSession().setAttribute("user",user);
            } catch (AuthenticationException e) {
                e.printStackTrace ();
                return "账号或密码错误！";
            } catch (AuthorizationException e) {
                e.printStackTrace ();
                return "没有权限";
            }
        }
        return "success";
    }

    @ApiOperation("注册")
    @Override
    public String regist (User user) {
        if (userRepository.findByUsername (user.getUsername ()) == null) {
            if (userRepository.findByPhone (user.getPhone ()) == null) {
                SnowFlake snowFlake = new SnowFlake ();
                user.setId (snowFlake.nextId ());
                user.setInvitationCode (String.valueOf (snowFlake.nextId ()));
                user.setRegisterTime (LocalDate.now ());
                user.setStatus (User.STATUS1);
                user.setInvitations (0L);
                passwordHelper.encryptPassword (user);
                userRepository.save (user);
                return "success";
            }
            return "手机号已经注册";
        }
        return "该用户名已经被注册";
    }

    @ApiOperation("发送验证码")
    @Override
    public String sendCaptcha (String phone) {
        User user = userRepository.findByPhone (phone);
        if (!StringUtil.isNullOrEmpty (user.getCaptcha ())) {
            if (System.currentTimeMillis () - Long.valueOf (user.getCaptcha ().substring (6, 19)) < 60000L) {
                return "发送验证码太频繁";
            }
        }
        String captcha = CodeUtil.generate6BitDigital ();
        user.setCaptcha (captcha);
        userRepository.save (user);
        return captcha.substring (0, 5);

    }

    @ApiOperation("手机号登录")
    public String loginByPhone (String phone, String captcha) {
        User user = userRepository.findByPhone (phone);
        Subject currentUser = SecurityUtils.getSubject ();

        if (captcha.equals (user.getCaptcha ().substring (0, 5))) {
            if (!currentUser.isAuthenticated ()) {
                UsernamePasswordToken token = new UsernamePasswordToken (user.getUsername (), user.getCurrentPassword ());
                token.setRememberMe (true);
                currentUser.login (token);
                return "success";
            }
        }
        return "验证码错误";
    }

    @ApiOperation("注销")
    @Override
    public String loginOut () {
        Subject currentUser = SecurityUtils.getSubject ();
        currentUser.logout ();
        return "success";
    }

    @ApiOperation("更新用户信息")
    public String update (User user) {
        passwordHelper.encryptPassword (user);
        userRepository.save (user);
        return "success";
    }

    @ApiOperation("删除用户")
    @Override
    public String deleteUsers (Long[] ids) {
        userRepository.deleteByUserIds (ids);
        return "success";
    }

    @ApiOperation("更新用户状态")
    @Override
    public String updateUserStatus (Long[] ids, String status) {
        userRepository.updateByUserIds (ids, status);
        return "success";
    }

    @ApiOperation("查询用户")
    @Override
    public Page<User> searchUsers (User user) {

        ExampleMatcher matcher = ExampleMatcher.matching ()
                .withMatcher ("username", ExampleMatcher.GenericPropertyMatchers.contains ())//模糊查询匹配开头，即{username}%
                .withIgnorePaths ("id");
        Example<User> example = Example.of (user, matcher);
        Pageable pageable = pageableUtil.getPageable (user.getPageExample ());

        return userRepository.findAll (example, pageable);
    }

    @ApiOperation ("获取用户个人信息")
    @Override
    public User findUserById(Long id){

        return  userRepository.findById (id).get ();
    }
}
