package com.ecut.design.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

/**
 * 活动表
 */
@Entity
@Table(name = "activity")
public class Activity implements Serializable {
    public static final String ACTIVITY_NOT_START = "未开始";
    public static final String ACTIVITY__HAVING = "进行中";
    public static final String ACTIVITY_OVERDUE_ = "已过期";

    @Id
    @GeneratedValue
    private Long id;
    /**
     * 活动名称
     */
    @ApiModelProperty(value = "activityNamme", required = true, position = 2, example = "活动名称")
    private String activityName;

    /**
     * 活动类型Id
     */
    @ApiModelProperty(value = "activityTypeId", required = true, position = 2, example = "1")
    private Long activityTypeId;
    /**
     * 活动类型
     */
    @Transient
    @ApiModelProperty(hidden=true)
    private ActivityType activityType;
    /**
     * 活动状态
     */
    @ApiModelProperty(value = "status", required = true, position = 2, example = "未开始")
    private String status;
    /**
     * 活动开始时间
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
    @ApiModelProperty(value = "activityStart", required = true, position = 2, example = "2020-01-05")
    private LocalDate activityStart;
    /**
     * 活动结束时间
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
    @ApiModelProperty(value = "activityEnd", required = true, position = 2, example = "2020-01-05")
    private LocalDate activityEnd;
    /**
     * 活动说明
     */
    @ApiModelProperty(value = "activityExplain", required = true, position = 2, example = "活动说明")
    private String activityExplain;
    /**
     * 活动图
     */
    @ApiModelProperty(value = "activityBanner", required = true, position = 2, example = "活动图地址")
    private String activityBanner;
    /**
     * 选项
     */
    @Transient
    private List<Options> optionsSet;

    @Transient
    private PageExample pageExample;

    public Long getId () {
        return id;
    }

    public void setId (Long id) {
        this.id = id;
    }

    public String getActivityName () {
        return activityName;
    }

    public void setActivityName (String activityName) {
        this.activityName = activityName;
    }

    public ActivityType getActivityType () {
        return activityType;
    }

    public void setActivityType (ActivityType activityType) {
        this.activityType = activityType;
    }

    public String getStatus () {
        return status;
    }

    public void setStatus (String status) {
        this.status = status;
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

    public String getActivityExplain () {
        return activityExplain;
    }

    public void setActivityExplain (String activityExplain) {
        this.activityExplain = activityExplain;
    }

    public String getActivityBanner () {
        return activityBanner;
    }

    public void setActivityBanner (String activityBanner) {
        this.activityBanner = activityBanner;
    }

    public List<Options> getOptionsSet () {
        return optionsSet;
    }

    public void setOptionsSet (List<Options> optionsSet) {
        this.optionsSet = optionsSet;
    }

    public Long getActivityTypeId () {
        return activityTypeId;
    }

    public void setActivityTypeId (Long activityTypeId) {
        this.activityTypeId = activityTypeId;
    }

    public PageExample getPageExample () {
        return pageExample;
    }

    public void setPageExample (PageExample pageExample) {
        this.pageExample = pageExample;
    }
}

