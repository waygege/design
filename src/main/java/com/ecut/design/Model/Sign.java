package com.ecut.design.Model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

/**
   * 活动报名表
 */
@Entity
@Table(name = "sign")
public class Sign {
      @Id
      @GeneratedValue
        private Long  id;
        /**
         * 用户Id
         */
        private Long userId;

        /**
         *报名的用户
         */
        @Transient
        private User user;

        /**
         * 报名的用户名
         */
        @Transient
        private String name;
        /**
         * 报名的用户手机号
         */
        @Transient
        private String phone;


        /**
         * 选项信息
         */
        @Transient
        private List<SignOptions> signOptions;
        /**
         * 活动Id
         *
         */
        private Long activityId;

        /**
         * 活动名
         *
         */
        @Transient
        private String activityName;
        /**
         * 活动开始时间
         */
        @Transient
        private LocalDate activityStart;


        /**
         * 活动结束时间
         */
        @Transient
        private LocalDate activityEnd;
        /**
         * 活动对象
         */

        @Transient
        private Activity activity;

        /**
         * 备注
         */
        private String  remark;

    public Long getId () {
        return id;
    }

    public void setId (Long id) {
        this.id = id;
    }

    public Long getUserId () {
        return userId;
    }

    public void setUserId (Long userId) {
        this.userId = userId;
    }

    public User getUser () {
        return user;
    }

    public void setUser (User user) {
        this.user = user;
    }

    public String getName () {
        return name;
    }

    public void setName (String name) {
        this.name = name;
    }

    public String getPhone () {
        return phone;
    }

    public void setPhone (String phone) {
        this.phone = phone;
    }

    public List<SignOptions> getSignOptions () {
        return signOptions;
    }

    public void setSignOptions (List<SignOptions> signOptions) {
        this.signOptions = signOptions;
    }

    public Long getActivityId () {
        return activityId;
    }

    public void setActivityId (Long activityId) {
        this.activityId = activityId;
    }

    public String getActivityName () {
        return activityName;
    }

    public void setActivityName (String activityName) {
        this.activityName = activityName;
    }

    public LocalDate getActivityStart () {
        return activityStart;
    }

    public void setActivityStart (LocalDate activityStart) {
        this.activityStart = activityStart;
    }

    public LocalDate getActivityEnd () {
        return activityEnd;
    }

    public void setActivityEnd (LocalDate activityEnd) {
        this.activityEnd = activityEnd;
    }

    public Activity getActivity () {
        return activity;
    }

    public void setActivity (Activity activity) {
        this.activity = activity;
    }

    public String getRemark () {
        return remark;
    }

    public void setRemark (String remark) {
        this.remark = remark;
    }
}
