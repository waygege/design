package com.ecut.design.Model;


import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import javax.persistence.Table;

/**
 *
 * 积分事件表
 */
@Entity
@Table(name = "evant_integral")
@Data
public class EventIntegral {
    @Id
    private  Long id;
    /**
     * 事件
     */
    @ApiModelProperty(value = "event", required = true, position = 2, example = "事件")
    private String event;
    /**
     * 积分数
     */
    @ApiModelProperty(value = "integral", required = true, position = 2, example = "10")
    private int integral;

}
