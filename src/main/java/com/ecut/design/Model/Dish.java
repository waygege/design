package com.ecut.design.Model;



import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;


import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 菜品
 */
@Entity
@Table(name="dish")
@Data
public class Dish implements Serializable {
    public static final String STATUS_NO_START= "未开始";
    public static final String STATUS_START= "已开始";
    public static final String STATUS_OVERDUE = "过期";
    public static final String STATUS_ON = "已上架";
    public static final String STATUS_NOT_ON= "已下架";

    @Id
    @GeneratedValue
    private Long id;
    /**
     * 状态
     */
    @ApiModelProperty(hidden=true)
    @JsonIgnore
    private String status;
    /**
     * 类型，分套餐和菜品
     */
    @ApiModelProperty(value = "type", required = true, position = 2, example = "菜品类型")
    private String type;
    /**
     * 配图
     */
    @ApiModelProperty(value = "image", required = true, position = 2, example = "菜品图片")
    private String image;
    /**
     * 开始日期
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "startDateTime", required = true, position = 2, example = "2020-01-05 12:00:00")
    private LocalDateTime startDateTime;
    /***
     * 结束日期
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "endDateTime", required = true, position = 2, example = "2020-01-05 12:00:00")
    private LocalDateTime endDateTime;
    /**
     * 名称
     */
    @ApiModelProperty(value = "title", required = true, position = 2, example = "名称")
    private String title;
    /**
     * 子标题
     */
    @ApiModelProperty(value = "subtitle", required = true, position = 2, example = "子标题")
    private String subtitle;
    /**
     * 售卖价
     */
    @ApiModelProperty(value = "salePrice", required = true, position = 2, example = "0.00")
    private BigDecimal salePrice;
    /**
     * 划线价/原始价格
     */
    @ApiModelProperty(value = "originalPrice", required = true, position = 2, example = "0.00")
    private BigDecimal originalPrice;
    /**
     * 描述
     */
    @ApiModelProperty(value = "description", required = true, position = 2, example = "描述")
    private String description;
    /**
     * 使用规则
     */
    @ApiModelProperty(value = "usageRule", required = true, position = 2, example = "使用规则")
    private String usageRule;
    /**
     *
     * 所属分类Id
     */
    @ApiModelProperty(value = "categoryId", required = true, position = 2, example = "1")
    private Long categoryId;
    /**
     * 所属分类
     */

    @Transient
    @ApiModelProperty(hidden=true)
    private Category category;
    /**
     * 排序
     */
    @ApiModelProperty(value = "sort", required = true, position = 2, example = "1")
    private int sort;

    /**
     * 餐馆Id
     */
    @ApiModelProperty(value = "restaurantId", required = true, position = 2, example = "1")
    private Long  restaurantId;
    /**
     * 参观对象
     */
    @Transient
    @ApiModelProperty(hidden=true)
    private Restaurant  restaurant;

    @Transient
    @ApiModelProperty(hidden=true)
    private PageExample pageExample;

}
