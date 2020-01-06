package com.ecut.design.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

/*
 * 轮播广告
 * */
@Entity
@Table(name = "banner")
public class Banner {
        /**
         * 未上架
         */
        public static final String STATUS_UNSHELVE = "未上架";
        /**
         * 已下架
         */
        public static final String STATUS_SOLDOUT= "已下架";
        /**
         *上架
          */
        public   static  final String STATUS_UP="上架";
         /**
         * 展示中
         */
        public static final String STATUS_ONSHOW = "展示中";
        /**
         * 已过期
         */
        public static final String STATUS_EXPIRED = "已过期";

        /*
         * banner
         * */
        public static final String CATEGORY_BANNER="banner";

        /*
         * 弹跳视窗
         * */
        public static final String CATEGORY_JUMP="jump";

        @Id
        @GeneratedValue
        private Long id;
        /*
         * 广告标题
         * */
        @ApiModelProperty(value = "bannerTitle", required = true, position = 2, example = "广告标题")
        private String bannerTitle;

        /*
         * 广告图
         * */
        @ApiModelProperty(value = "bannerPicture", required = true, position = 2, example = "广告图片地址")
        private String bannerPicture;

        /*
         * 序号
         * */
        @ApiModelProperty(value = "position", required = true, position = 2, example = "1")
        private Long position;

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
         * 状态
         * */
        @ApiModelProperty(value = "status", required = true, position = 2, example = "未开始")
        private String status;

        /*
         * 跳转链接
         * */
        @ApiModelProperty(value = "jumpLink", required = true, position = 2, example = "跳转链接")
        private String jumpLink;

        /*
         *   banner分类
         *   banner      "bannerCategory": "banner"
         *   弹窗视图    "bannerCategory": "jump"
         * */
        @ApiModelProperty(value = "bannerCategory", required = true, position = 2, example = "banner分类")
        private String bannerCategory;

        /*
         * 弹跳视窗会选择选相关用户进行推送
         * */

        @Transient
        @ApiModelProperty(hidden=true)
        private List<User> users;

        @Transient
        @ApiModelProperty(hidden=true)
        private List<Long> userIds;


        @Transient
        @ApiModelProperty(hidden=true)
       private  PageExample pageExample;


    public Long getId () {
        return id;
    }

    public void setId (Long id) {
        this.id = id;
    }

    public String getBannerTitle () {
        return bannerTitle;
    }

    public void setBannerTitle (String bannerTitle) {
        this.bannerTitle = bannerTitle;
    }

    public String getBannerPicture () {
        return bannerPicture;
    }

    public void setBannerPicture (String bannerPicture) {
        this.bannerPicture = bannerPicture;
    }

    public Long getPosition () {
        return position;
    }

    public void setPosition (Long position) {
        this.position = position;
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

    public String getJumpLink () {
        return jumpLink;
    }

    public void setJumpLink (String jumpLink) {
        this.jumpLink = jumpLink;
    }

    public String getBannerCategory () {
        return bannerCategory;
    }

    public void setBannerCategory (String bannerCategory) {
        this.bannerCategory = bannerCategory;
    }

    public List<User> getUsers () {
        return users;
    }

    public void setUsers (List<User> users) {
        this.users = users;
    }

    public List<Long> getUserIds () {
        return userIds;
    }

    public void setUserIds (List<Long> userIds) {
        this.userIds = userIds;
    }

    public PageExample getPageExample () {
        return pageExample;
    }

    public void setPageExample (PageExample pageExample) {
        this.pageExample = pageExample;
    }
}
