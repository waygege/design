package com.ecut.design.Config;

import com.ecut.design.Model.SysPermission;
import com.ecut.design.Model.SysRole;
import com.ecut.design.Model.User;
import com.ecut.design.Repository.UserRepository;
import com.ecut.design.Service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;



public class EnceladusShiroRealm extends AuthorizingRealm {
    @Autowired
    private UserRepository userRepository;


    //执行授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
       //创建一个授权对象
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        //获取当前的负责信息（也就是当前用户信息），得到认证成功之后凭证的身份信息
        String username = (String) principals.getPrimaryPrincipal();
        User user = userRepository.findByUsername(username);
        //获取当前登录用户
        for (SysRole role : user.getRoles()) {
            //获取当前用户拥有的所有角色
            authorizationInfo.addRole(role.getRole());
            for (SysPermission permission : role.getPermissions()) {
                //获取当前用户所拥有的的资源
                authorizationInfo.addStringPermission(permission.getName());
            }
        }
        return authorizationInfo;
    }
    //执行认证逻辑
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //shiro判断逻辑
        String username = (String) token.getPrincipal();

        User user = userRepository.findByUsername (username);
        //用户名错误
        //shiro会抛出UnknownAccountException异常
        if (user == null) {
           return null;
        }
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(user.getUsername(), user.getPassword(),
                ByteSource.Util.bytes(user.getCredentialsSalt()), getName());
        return authenticationInfo;
    }

}