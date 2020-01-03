package com.ecut.design.Model;

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
    private Long billNumber;
    /**
     * 交易日期
     */
    private LocalDate transationDate;
    /**
     * 查询开始日期
     */
    private LocalDate transationDateStart;
    /**
     * 查询结束日期
     */
    private LocalDate transationDateEnd;
    /**
     * 会员名
     */
    private String memberName;
    /**
     * 用户Id
     */
    private Long  userId;
    /**
     *交易金额
     */
    private BigDecimal transationMoney;
    /**
     * 实付金额
     */
    private BigDecimal payMoney;
    /**
     * 餐馆名称
     */
    @Transient
    private Restaurant restaurant;
    /**
     * 餐馆id
     */
    private Long restaurantId;
    /**
     * 状态
     */
    private String status;
    /**
     *     会员号
     */
    private Long memberId;

    @Transient
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
