package com.ecut.design.Model;




import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;

import java.time.LocalDateTime;

/*
 *评价表
 */
@Entity
@Table(name = "evaluate")
public class Evaluate {

    public static final String STATUS_ENABLE = "启用";
    public static final String STATUS_DISABLE = "禁用";

    @Id
    @GeneratedValue
    private Long id;
    /**
     * 评价时间
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime commentTime;
    /**
     * 状态
     */
    private String status;
    /**
     * 评价内容问题
     */
    private String content;
    /**
     * 评价星数
     */
    private Integer stars;
    /**
     * 评价用户用户Id
     */
    private  Long userId;

    /**
     * 评价餐馆Id
     */
    private Long restaurantId;
    /**
     *搜索评价开始时间
     */
    @Transient
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime commentStartTime;
    /**
     *搜索评价结束时间
     */
    @Transient
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime commentEndTime;
    /**
     * 评价用户
     */
    @Transient
    private User user;
    /**
     * 评价餐厅
     */
    @Transient
    private  Restaurant restaurant;

    public Long getId () {
        return id;
    }

    public void setId (Long id) {
        this.id = id;
    }

    public LocalDateTime getCommentTime () {
        return commentTime;
    }

    public void setCommentTime (LocalDateTime commentTime) {
        this.commentTime = commentTime;
    }

    public String getStatus () {
        return status;
    }

    public void setStatus (String status) {
        this.status = status;
    }

    public String getContent () {
        return content;
    }

    public void setContent (String content) {
        this.content = content;
    }

    public Integer getStars () {
        return stars;
    }

    public void setStars (Integer stars) {
        this.stars = stars;
    }

    public Long getUserId () {
        return userId;
    }

    public void setUserId (Long userId) {
        this.userId = userId;
    }

    public Long getRestaurantId () {
        return restaurantId;
    }

    public void setRestaurantId (Long restaurantId) {
        this.restaurantId = restaurantId;
    }

    public LocalDateTime getCommentStartTime () {
        return commentStartTime;
    }

    public void setCommentStartTime (LocalDateTime commentStartTime) {
        this.commentStartTime = commentStartTime;
    }

    public LocalDateTime getCommentEndTime () {
        return commentEndTime;
    }

    public void setCommentEndTime (LocalDateTime commentEndTime) {
        this.commentEndTime = commentEndTime;
    }

    public User getUser () {
        return user;
    }

    public void setUser (User user) {
        this.user = user;
    }

    public Restaurant getRestaurant () {
        return restaurant;
    }

    public void setRestaurant (Restaurant restaurant) {
        this.restaurant = restaurant;
    }
}
