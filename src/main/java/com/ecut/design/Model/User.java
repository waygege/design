package com.ecut.design.Model;


import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.*;

/**
 * 用户
 */
@Entity
@Table(name = "user_t")
public class User implements Serializable {
    public static final String STATUS1="启用";
    public static final String STATUS2="禁用";

    @Id
    private long id;
    /**
     * token
     */
    private String token;
    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String currentPassword;
    /**
     * 加密后的密码
     */
    private String password;
    /**
     * 盐值
     */
    private String salt;
    /**
     * 手机号
     */
    private String phone;
    /**
     * 验证码
     */
    private String captcha;
    /**
     * 头像
     */
    private String avatar;
    /**
     * 生日
     */
    private LocalDate birthday;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 状态
     */
    private String status;

    /**
     * 邀请码
     */
    private String invitationCode;
    /**
     * 邀请人数
     */
    private Long invitations;
    /**
     * 会员等级
     */
    private String level;
    /**
     * 注册时间
     */
    private LocalDate registerTime;
    /**
     * 是否接受推送
     */
    private String isAcceptPush;
    /**
     * 常去餐厅
     */
    private String restaurantId;
    /**
     * 积分
     */
    private Long integral;

    @Transient
    private  PageExample pageExample;


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_role_t", joinColumns = { @JoinColumn(name = "uid") },
            inverseJoinColumns = {@JoinColumn(name = "rid") })
    @Transient
    private List<SysRole> roles;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getToken () {
        return token;
    }

    public void setToken (String token) {
        this.token = token;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public List<SysRole> getRoles() {
        return roles;
    }

    public void setRoles(List<SysRole> roles) {
        this.roles = roles;
    }

    public String getCredentialsSalt() {
        return username + salt + salt;
    }

    public String getCurrentPassword () {
        return currentPassword;
    }

    public void setCurrentPassword (String currentPassword) {
        this.currentPassword = currentPassword;
    }

    public String getPhone () {
        return phone;
    }

    public void setPhone (String phone) {
        this.phone = phone;
    }

    public String getCaptcha () {
        return captcha;
    }

    public void setCaptcha (String captcha) {
        this.captcha = captcha;
    }

    public String getAvatar () {
        return avatar;
    }

    public void setAvatar (String avatar) {
        this.avatar = avatar;
    }


    public LocalDate getBirthday () {
        return birthday;
    }

    public void setBirthday (LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getEmail () {
        return email;
    }

    public void setEmail (String email) {
        this.email = email;
    }

    public String getStatus () {
        return status;
    }

    public void setStatus (String status) {
        this.status = status;
    }

    public String getInvitationCode () {
        return invitationCode;
    }

    public void setInvitationCode (String invitationCode) {
        this.invitationCode = invitationCode;
    }

    public Long getInvitations () {
        return invitations;
    }

    public void setInvitations (Long invitations) {
        this.invitations = invitations;
    }

    public String getLevel () {
        return level;
    }

    public void setLevel (String level) {
        this.level = level;
    }

    public LocalDate getRegisterTime () {
        return registerTime;
    }

    public void setRegisterTime (LocalDate registerTime) {
        this.registerTime = registerTime;
    }

    public String getIsAcceptPush () {
        return isAcceptPush;
    }

    public void setIsAcceptPush (String isAcceptPush) {
        this.isAcceptPush = isAcceptPush;
    }

    public String getRestaurantId () {
        return restaurantId;
    }

    public void setRestaurantId (String restaurantId) {
        this.restaurantId = restaurantId;
    }

    public Long getIntegral () {
        return integral;
    }

    public void setIntegral (Long integral) {
        this.integral = integral;
    }

    public PageExample getPageExample () {
        return pageExample;
    }

    public void setPageExample (PageExample pageExample) {
        this.pageExample = pageExample;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", username=" + username + "]";
    }

}
