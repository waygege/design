package com.ecut.design.Model;



import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;


import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 菜品
 */
@Entity
@Table(name="dish")
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
    @JsonIgnore
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
    @JsonIgnore
    private Restaurant  restaurant;

    @Transient
    @ApiModelProperty(hidden=true)
    @JsonIgnore
    private PageExample pageExample;

    public Long getId () {
        return id;
    }

    public void setId (Long id) {
        this.id = id;
    }

    public String getStatus () {
        return status;
    }

    public void setStatus (String status) {
        this.status = status;
    }

    public String getType () {
        return type;
    }

    public void setType (String type) {
        this.type = type;
    }

    public String getImage () {
        return image;
    }

    public void setImage (String image) {
        this.image = image;
    }

    public LocalDateTime getStartDateTime () {
        return startDateTime;
    }

    public void setStartDateTime (LocalDateTime startDateTime) {
        this.startDateTime = startDateTime;
    }

    public LocalDateTime getEndDateTime () {
        return endDateTime;
    }

    public void setEndDateTime (LocalDateTime endDateTime) {
        this.endDateTime = endDateTime;
    }

    public String getTitle () {
        return title;
    }

    public void setTitle (String title) {
        this.title = title;
    }

    public String getSubtitle () {
        return subtitle;
    }

    public void setSubtitle (String subtitle) {
        this.subtitle = subtitle;
    }

    public BigDecimal getSalePrice () {
        return salePrice;
    }

    public void setSalePrice (BigDecimal salePrice) {
        this.salePrice = salePrice;
    }

    public BigDecimal getOriginalPrice () {
        return originalPrice;
    }

    public void setOriginalPrice (BigDecimal originalPrice) {
        this.originalPrice = originalPrice;
    }

    public String getDescription () {
        return description;
    }

    public void setDescription (String description) {
        this.description = description;
    }

    public String getUsageRule () {
        return usageRule;
    }

    public void setUsageRule (String usageRule) {
        this.usageRule = usageRule;
    }

    public Long getCategoryId () {
        return categoryId;
    }

    public void setCategoryId (Long categoryId) {
        this.categoryId = categoryId;
    }

    public Category getCategory () {
        return category;
    }

    public void setCategory (Category category) {
        this.category = category;
    }

    public int getSort () {
        return sort;
    }

    public void setSort (int sort) {
        this.sort = sort;
    }

    public Long getRestaurantId () {
        return restaurantId;
    }

    public void setRestaurantId (Long restaurantId) {
        this.restaurantId = restaurantId;
    }

    public Restaurant getRestaurant () {
        return restaurant;
    }

    public void setRestaurant (Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public PageExample getPageExample () {
        return pageExample;
    }

    public void setPageExample (PageExample pageExample) {
        this.pageExample = pageExample;
    }
}
