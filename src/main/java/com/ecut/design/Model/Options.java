package com.ecut.design.Model;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * 活动问题选项表
 */
@Entity
@Table(name = "options")
public class Options implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    /**
     * 选项标题
     */
    @ApiModelProperty(value = "title",example = "标题",required = true)
    private String title;
    /**
     * 选项A
     */
    @ApiModelProperty(value = "attributeA" ,example = "选项A",required = true)
    private String attributeA;
    /**
     * 选项B
     */
    @ApiModelProperty(value = "attributeB" ,example = "选项B",required = true)
    private String attributeB;
    /**
     * 选项C
     */
    @ApiModelProperty(value = "attributeC" ,example = "选项C",required = true)
    private String attributeC;
    /**
     * 选项D
     */
    @ApiModelProperty(value = "attributeD" ,example = "选项D",required = true)
    private String attributeD;
    /**
     * 活动ID
     */
    @ApiModelProperty(value = "activityId" ,example = "1",required = true)
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

    public String getAttributeA () {
        return attributeA;
    }

    public void setAttributeA (String attributeA) {
        this.attributeA = attributeA;
    }

    public String getAttributeB () {
        return attributeB;
    }

    public void setAttributeB (String attributeB) {
        this.attributeB = attributeB;
    }

    public String getAttributeC () {
        return attributeC;
    }

    public void setAttributeC (String attributeC) {
        this.attributeC = attributeC;
    }

    public String getAttributeD () {
        return attributeD;
    }

    public void setAttributeD (String attributeD) {
        this.attributeD = attributeD;
    }

    public Long getActivityId () {
        return activityId;
    }

    public void setActivityId (Long activityId) {
        this.activityId = activityId;
    }
}

