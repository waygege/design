package com.ecut.design.Model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 活动类型表
 */
@Entity
@Table(name="activity_type")
@Data
public class ActivityType implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    /**
     * 活动类型名
     */
    @ApiModelProperty(value = "activityTypeName", required = true, position = 2, example = "活动类型名")
    private String activityTypeName;

    @Transient
    @ApiModelProperty(hidden=true)
    private PageExample pageExample;


}