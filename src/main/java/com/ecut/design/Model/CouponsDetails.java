package com.ecut.design.Model;


import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

/*
 * 优惠卷详情
 * */
@Entity
@Table(name = "coupons_details")
public class CouponsDetails {
    /*
     * 未领取
     * */
    public static final String STATUS_UNRECEIVED = "未领取";
    /**
     * 未使用
     */
    public static final String STATUS_ACTIVE = "未使用";
    /**
     * 已使用
     */
    public static final String STATUS_USED = "已使用";
    /**
     * 已过期
     */
    public static final String STATUS_EXPIRED = "已过期";

    @Id
    @GeneratedValue
    private Long id;
    /*
     * 优惠卷编号
     * */
    private String couponsCode;
    /*
     * 兑换码
     * */
    private String cdKey;
    /**
     * 领取时间
     */
    private LocalDateTime createAt;
    /**
     * 状态
     */
    private String status;

    /**
     * 所属优惠券Id
     */
    private Long couponsId;

    /**
     * 核销时间
     */
    private LocalDateTime usedAt;
    /**
     * 用户ID
     */
    private Long userId;
    /*
     * 赠送数量
     * */
    @Transient
    private Long amount;

    /**
     * 赠送的所有用户
     */
    @Transient
    private List<Long> userIds;
    /*
     * 优惠卷名称
     * */
    @Transient
    private String couponsName;

    /*
     * 优惠卷说明
     * */
    @Transient
    private String couponDescription;

    /*
     * 使用规则
     * */
    @Transient
    private String rules;

    /*
     * 优惠卷开始时间
     * */
    @Transient
    private LocalDateTime startTime;
    /*
     * 优惠卷结束时间
     * */
    @Transient
    private LocalDateTime endTime;

    /*
     * 哪些餐馆可用
     * */
    @Transient
    private List<Restaurant> restaurants;


    @Transient
    private PageExample pageExample;

    public Long getId () {
        return id;
    }

    public void setId (Long id) {
        this.id = id;
    }

    public String getCouponsCode () {
        return couponsCode;
    }

    public void setCouponsCode (String couponsCode) {
        this.couponsCode = couponsCode;
    }

    public String getCdKey () {
        return cdKey;
    }

    public void setCdKey (String cdKey) {
        this.cdKey = cdKey;
    }

    public LocalDateTime getCreateAt () {
        return createAt;
    }

    public void setCreateAt (LocalDateTime createAt) {
        this.createAt = createAt;
    }

    public String getStatus () {
        return status;
    }

    public void setStatus (String status) {
        this.status = status;
    }

    public Long getCouponsId () {
        return couponsId;
    }

    public void setCouponsId (Long couponsId) {
        this.couponsId = couponsId;
    }

    public LocalDateTime getUsedAt () {
        return usedAt;
    }

    public void setUsedAt (LocalDateTime usedAt) {
        this.usedAt = usedAt;
    }

    public Long getUserId () {
        return userId;
    }

    public void setUserId (Long userId) {
        this.userId = userId;
    }

    public Long getAmount () {
        return amount;
    }

    public void setAmount (Long amount) {
        this.amount = amount;
    }

    public List<Long> getUserIds () {
        return userIds;
    }

    public void setUserIds (List<Long> userIds) {
        this.userIds = userIds;
    }

    public String getCouponsName () {
        return couponsName;
    }

    public void setCouponsName (String couponsName) {
        this.couponsName = couponsName;
    }

    public String getCouponDescription () {
        return couponDescription;
    }

    public void setCouponDescription (String couponDescription) {
        this.couponDescription = couponDescription;
    }

    public String getRules () {
        return rules;
    }

    public void setRules (String rules) {
        this.rules = rules;
    }

    public LocalDateTime getStartTime () {
        return startTime;
    }

    public void setStartTime (LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime () {
        return endTime;
    }

    public void setEndTime (LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public List<Restaurant> getRestaurants () {
        return restaurants;
    }

    public void setRestaurants (List<Restaurant> restaurants) {
        this.restaurants = restaurants;
    }



    public PageExample getPageExample () {
        return pageExample;
    }

    public void setPageExample (PageExample pageExample) {
        this.pageExample = pageExample;
    }
}
