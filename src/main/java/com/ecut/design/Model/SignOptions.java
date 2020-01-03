package com.ecut.design.Model;


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
    private String title;
    /**
     * 选择选项
     */
    private String attribute;
    /**
     * 报名活动Id
     */
    private Long signId;

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

    public Long getSignId () {
        return signId;
    }

    public void setSignId (Long signId) {
        this.signId = signId;
    }
}
