package com.ecut.design.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

/**
 * 交易记录表
 */
@Entity
@Table(name = "transation_amount")
@Data
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



}
