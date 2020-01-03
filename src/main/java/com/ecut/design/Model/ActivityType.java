package com.ecut.design.Model;


import javax.persistence.*;
import java.io.Serializable;

/**
 * 活动类型表
 */
@Entity
@Table(name="activity_type")
public class ActivityType implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    /**
     * 活动类型名
     */
    private String activityTypeName;

    @Transient
    private PageExample pageExample;

    public Long getId () {
        return id;
    }

    public void setId (Long id) {
        this.id = id;
    }

    public String getActivityTypeName () {
        return activityTypeName;
    }

    public void setActivityTypeName (String activityTypeName) {
        this.activityTypeName = activityTypeName;
    }

    public PageExample getPageExample () {
        return pageExample;
    }

    public void setPageExample (PageExample pageExample) {
        this.pageExample = pageExample;
    }
}