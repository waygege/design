package com.ecut.design.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 优惠卷
 */

@Entity
@Table(name = "coupons")
public class Coupons {


    /**
     * 未上架
     */
    public static  final String STATUS_SATRT="未上架";
    /**
     * 已下架
     */
    public static final String STATUS_SOLDOUT = "已下架";

    /**
     * 已上架
     */
    public static final String STATUS_ONSHOW = "已上架";
    /**
     * 已过期
     */
    public static final String STATUS_TIMEOUT = "已过期";


    /*
     * 优惠卷Id
     * */
    @Id
    @GeneratedValue
    private Long Id;

    /*
     * 优惠卷名称
     * */
    private String couponsName;

    /*
     * 优惠卷说明
     * */
    private String couponDescription;

    /*
     * 优惠券类型
     * */
    private String couponsType;


    /*
     * 开始时间
     * */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime startTime;
    /*
     * 结束时间
     * */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime endTime;



    /*
     * 发放总数
     * */
    @Transient
    @ApiModelProperty(hidden=true)
    @JsonIgnore
    private Integer issueTotal;
    /*
     * 领取总数
     * */
    @Transient
    @ApiModelProperty(hidden=true)
    @JsonIgnore
    private Integer receivedTotal;

    /*
     * 使用总数
     * */
    @Transient
    @ApiModelProperty(hidden=true)
    @JsonIgnore
    private Integer usedTotal;


    /*
     * 优惠卷状态
     * */
    private String status;

    /*
     * 所需积分
     * */
    private Long integration;
    /*
     * 使用规则
     * */

    private String rules;

    /*
     * 优惠卷种类
     * */
    private String couponsCategory;

    /*
     * 活动门店
     * */

    @Transient
    @ApiModelProperty(hidden=true)
    @JsonIgnore
    private List<Long> restaurants;

    @Transient
    @ApiModelProperty(hidden=true)
    @JsonIgnore
    private Long restaurantId;
    /*
     * 赠送的用户
     * */
    @Transient
    @ApiModelProperty(hidden=true)
    @JsonIgnore
    private List<User> users;

    @Transient
    @ApiModelProperty(hidden=true)
    @JsonIgnore
    private PageExample pageExample;

    public Long getId () {
        return Id;
    }

    public void setId (Long id) {
        Id = id;
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

    public String getCouponsType () {
        return couponsType;
    }

    public void setCouponsType (String couponsType) {
        this.couponsType = couponsType;
    }

    public Integer getIssueTotal () {
        return issueTotal;
    }

    public void setIssueTotal (Integer issueTotal) {
        this.issueTotal = issueTotal;
    }

    public Integer getReceivedTotal () {
        return receivedTotal;
    }

    public void setReceivedTotal (Integer receivedTotal) {
        this.receivedTotal = receivedTotal;
    }

    public Integer getUsedTotal () {
        return usedTotal;
    }

    public void setUsedTotal (Integer usedTotal) {
        this.usedTotal = usedTotal;
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


    public String getStatus () {
        return status;
    }

    public void setStatus (String status) {
        this.status = status;
    }

    public Long getIntegration () {
        return integration;
    }

    public void setIntegration (Long integration) {
        this.integration = integration;
    }

    public String getRules () {
        return rules;
    }

    public void setRules (String rules) {
        this.rules = rules;
    }

    public String getCouponsCategory () {
        return couponsCategory;
    }

    public void setCouponsCategory (String couponsCategory) {
        this.couponsCategory = couponsCategory;
    }

    public List<Long> getRestaurants () {
        return restaurants;
    }

    public void setRestaurants (List<Long> restaurants) {
        this.restaurants = restaurants;
    }

    public Long getRestaurantId () {
        return restaurantId;
    }

    public void setRestaurantId (Long restaurantId) {
        this.restaurantId = restaurantId;
    }

    public List<User> getUsers () {
        return users;
    }

    public void setUsers (List<User> users) {
        this.users = users;
    }

    public PageExample getPageExample () {
        return pageExample;
    }

    public void setPageExample (PageExample pageExample) {
        this.pageExample = pageExample;
    }
}

