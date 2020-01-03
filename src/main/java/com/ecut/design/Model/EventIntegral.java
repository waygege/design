package com.ecut.design.Model;


import javax.persistence.*;
import javax.persistence.Table;

/**
 *
 * 积分事件表
 */
@Entity
@Table(name = "evant_integral")
public class EventIntegral {
    @Id
    private  Long id;
    /**
     * 事件
     */
    private String event;
    /**
     * 积分数
     */
    private int integral;

    public Long getId () {
        return id;
    }

    public void setId (Long id) {
        this.id = id;
    }

    public String getEvent () {
        return event;
    }

    public void setEvent (String event) {
        this.event = event;
    }

    public int getIntegral () {
        return integral;
    }

    public void setIntegral (int integral) {
        this.integral = integral;
    }
}
