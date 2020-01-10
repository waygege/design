package com.ecut.design.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 优惠卷
 */

@Entity
@Table(name = "coupons")
@Data
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
    @ApiModelProperty(value = "couponsName", required = true, position = 2, example = "优惠卷名")
    private String couponsName;

    /*
     * 优惠卷说明
     * */
    @ApiModelProperty(value = "couponDescription", required = true, position = 2, example = "优惠卷描述")
    private String couponDescription;

    /*
     * 优惠券类型
     * */
    @ApiModelProperty(value = "couponsType", required = true, position = 2, example = "优惠卷类型")
    private String couponsType;


    /*
     * 开始时间
     * */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "startTime", required = true, position = 2, example = "2020-01-05 12:00:00")
    private LocalDateTime startTime;
    /*
     * 结束时间
     * */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "endTime", required = true, position = 2, example = "2020-01-05 12:00:00")
    private LocalDateTime endTime;



    /*
     * 发放总数
     * */
    @Transient
    @ApiModelProperty(hidden=true)
    private Integer issueTotal;
    /*
     * 领取总数
     * */
    @Transient
    @ApiModelProperty(hidden=true)
    private Integer receivedTotal;

    /*
     * 使用总数
     * */
    @Transient
    @ApiModelProperty(hidden=true)
    private Integer usedTotal;


    /*
     * 优惠卷状态
     * */
    @ApiModelProperty(value = "status", required = true, position = 2, example = "未开始")
    private String status;

    /*
     * 所需积分
     * */
    @ApiModelProperty(value = "integration", required = true, position = 2, example = "0")
    private Long integration;
    /*
     * 使用规则
     * */
    @ApiModelProperty(value = "rules", required = true, position = 2, example = "使用规则")
    private String rules;

    /*
     * 优惠卷种类
     * */
    @ApiModelProperty(value = "couponsCategory", required = true, position = 2, example = "优惠卷种类")
    private String couponsCategory;

    /*
     * 活动门店
     * */

    @Transient
    @ApiModelProperty(hidden=true)
    private List<Long> restaurants;

    @Transient
    @ApiModelProperty(hidden=true)
    private Long restaurantId;
    /*
     * 赠送的用户
     * */
    @Transient
    @ApiModelProperty(hidden=true)
    private List<User> users;

    @Transient
    @ApiModelProperty(hidden=true)
    private PageExample pageExample;
}

