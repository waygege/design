package com.ecut.design.Model;

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
    private String title;
    /**
     * 选项A
     */
    private String attributeA;
    /**
     * 选项B
     */
    private String attributeB;
    /**
     * 选项C
     */
    private String attributeC;
    /**
     * 选项D
     */
    private String attributeD;
    /**
     * 活动ID
     */
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

