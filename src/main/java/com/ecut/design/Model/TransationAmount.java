package com.ecut.design.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

/**
 * 交易记录表
 */
@Entity
@Table(name = "transation_amount")
public class TransationAmount {

    @Id
    @GeneratedValue
    private Long id;
    /**
     * 账单号
     */
    @ApiModelProperty(value = "billNumber",example = "16876496874115",required = true)
    private Long billNumber;
    /**
     * 交易日期
     */
    @ApiModelProperty(value = "transationDate", example = "2020-01-05 12:00:00",required = true)
    private LocalDate transationDate;
    /**
     * 查询开始日期
     */
    @Transient
    @ApiModelProperty(value = "transationDateStart", example = "2020-01-05 12:00:00",required = true)
    private LocalDate transationDateStart;
    /**
     * 查询结束日期
     */
    @Transient
    @ApiModelProperty(value = "transationDateEnd", example = "2020-01-05 12:00:00",required = true)
    private LocalDate transationDateEnd;
    /**
     * 会员名
     */
    @ApiModelProperty(value = "memberName", example = "会员名",required = true)
    private String memberName;
    /**
     * 用户Id
     */
    @ApiModelProperty(value = "userId", example = "1",required = true)
    private Long  userId;
    /**
     *交易金额
     */
    @ApiModelProperty(value = "transationMoney", example = "100.00",required = true)
    private BigDecimal transationMoney;
    /**
     * 实付金额
     */
    @ApiModelProperty(value = "payMoney", example = "100.00",required = true)
    private BigDecimal payMoney;
    /**
     * 餐馆名称
     */
    @Transient
    @ApiModelProperty(hidden=true)
    private Restaurant restaurant;
    /**
     * 餐馆id
     */
    private Long restaurantId;
    /**
     * 状态
     */
    @ApiModelProperty(value = "status", example = "状态",required = true)
    private String status;
    /**
     *     会员号
     */
    @ApiModelProperty(value = "memberId", example = "1",required = true)
    private Long memberId;

    @Transient
    @ApiModelProperty(hidden=true)
    private PageExample pageExample;


    public Long getId () {
        return id;
    }

    public void setId (Long id) {
        this.id = id;
    }

    public Long getBillNumber () {
        return billNumber;
    }

    public void setBillNumber (Long billNumber) {
        this.billNumber = billNumber;
    }

    public LocalDate getTransationDate () {
        return transationDate;
    }

    public void setTransationDate (LocalDate transationDate) {
        this.transationDate = transationDate;
    }

    public LocalDate getTransationDateStart () {
        return transationDateStart;
    }

    public void setTransationDateStart (LocalDate transationDateStart) {
        this.transationDateStart = transationDateStart;
    }

    public LocalDate getTransationDateEnd () {
        return transationDateEnd;
    }

    public void setTransationDateEnd (LocalDate transationDateEnd) {
        this.transationDateEnd = transationDateEnd;
    }

    public String getMemberName () {
        return memberName;
    }

    public void setMemberName (String memberName) {
        this.memberName = memberName;
    }

    public Long getUserId () {
        return userId;
    }

    public void setUserId (Long userId) {
        this.userId = userId;
    }

    public BigDecimal getTransationMoney () {
        return transationMoney;
    }

    public void setTransationMoney (BigDecimal transationMoney) {
        this.transationMoney = transationMoney;
    }

    public BigDecimal getPayMoney () {
        return payMoney;
    }

    public void setPayMoney (BigDecimal payMoney) {
        this.payMoney = payMoney;
    }

    public Restaurant getRestaurant () {
        return restaurant;
    }

    public void setRestaurant (Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public Long getRestaurantId () {
        return restaurantId;
    }

    public void setRestaurantId (Long restaurantId) {
        this.restaurantId = restaurantId;
    }

    public String getStatus () {
        return status;
    }

    public void setStatus (String status) {
        this.status = status;
    }

    public Long getMemberId () {
        return memberId;
    }

    public void setMemberId (Long memberId) {
        this.memberId = memberId;
    }

    public PageExample getPageExample () {
        return pageExample;
    }

    public void setPageExample (PageExample pageExample) {
        this.pageExample = pageExample;
    }
}
