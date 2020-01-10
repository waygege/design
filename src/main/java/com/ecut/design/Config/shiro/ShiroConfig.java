package com.ecut.design.Config.shiro;

import java.util.HashMap;
import java.util.Map;


import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ShiroConfig {



    //过滤器配置
    @Bean
    public ShiroFilterFactoryBean shirFilter(SecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);

        Map<String, String> filterChainDefinitionMap = new HashMap<String, String>();
        shiroFilterFactoryBean.setLoginUrl("/login");
        shiroFilterFactoryBean.setUnauthorizedUrl("/unauthc");//设置没有权限的页面
        shiroFilterFactoryBean.setSuccessUrl("/home/index");//登录成功后会跳转到该界面

        //filterChainDefinitionMap.put("/*", "anon");//anon 可以理解为不拦截
        //filterChainDefinitionMap.put("/sign", "authc");//需要认证后才可以访问
       // filterChainDefinitionMap.put("/couponsDetails/sendCouponsDetails", "authc");
        filterChainDefinitionMap.put("/authc/admin", "roles[admin]");//需要该用户有这个（或多个）角色才可以访问
        filterChainDefinitionMap.put("/authc/renewable", "perms[Create,Update]");//必须拥有该俩个权限才可以访问
        filterChainDefinitionMap.put("/authc/removable", "perms[Delete]");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return shiroFilterFactoryBean;
    }

    //密码加密
    @Bean
    public HashedCredentialsMatcher hashedCredentialsMatcher() {
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
        hashedCredentialsMatcher.setHashAlgorithmName(PasswordHelper.ALGORITHM_NAME); // 散列算法
        hashedCredentialsMatcher.setHashIterations(PasswordHelper.HASH_ITERATIONS); // 散列次数
        return hashedCredentialsMatcher;
    }
   //安全实体数据源
    @Bean
    public EnceladusShiroRealm shiroRealm() {
        EnceladusShiroRealm shiroRealm = new EnceladusShiroRealm();
        shiroRealm.setCredentialsMatcher(hashedCredentialsMatcher());//设置凭证匹配器
        return shiroRealm;
}

    // 安全管理
    @Bean
    public SecurityManager securityManager() {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(shiroRealm());//设置安全实体数据源
        return securityManager;
    }

    @Bean
    public PasswordHelper passwordHelper() {
        return new PasswordHelper();
    }

/*    @Bean
    public CookieRememberMeManager cookieRememberMeManager() {
    CookieRememberMeManager cookieRememberMeManager = new CookieRememberMeManager();
    SimpleCookie simpleCookie = new SimpleCookie("rememberMe");
    simpleCookie.setMaxAge(259200000);
    cookieRememberMeManager.setCookie(simpleCookie);
    cookieRememberMeManager.setCipherKey(Base64.decode("6ZmI6I2j5Y+R5aSn5ZOlAA=="));
    return cookieRememberMeManager;
    }*/
}