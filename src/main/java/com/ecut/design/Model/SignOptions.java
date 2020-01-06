package com.ecut.design.Model;


import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

/**
 * 报名选项表
 */
@Entity
@Table(name = "sign_options")
public class SignOptions {
    @Id
    @GeneratedValue
    private Long  id;
    /**
     * 选项标题
     */
    @ApiModelProperty(value = "title",example = "标题",required = true)
    private String title;
    /**
     * 选择选项
     */
    @ApiModelProperty(value = "attribute",example = "选项",required = true)
    private String attribute;
    /**
     * 报名活动Id
     */
    @ApiModelProperty(value = "attribute",example = "报名活动Id",required = true)
    private Long activityId;

    public Long getId () {
        return id;
    }

    public void setId (Long id) {
        this.id = id;
    }

    public String getTitle () {
        return title;
    }

    public void setTitle (String title) {
        this.title = title;
    }

    public String getAttribute () {
        return attribute;
    }

    public void setAttribute (String attribute) {
        this.attribute = attribute;
    }

    public Long getActivityId () {
        return activityId;
    }

    public void setActivityId (Long activityId) {
        this.activityId = activityId;
    }
}
