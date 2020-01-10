package com.ecut.design.Model;


import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;

/**
 * 报名选项表
 */
@Entity
@Table(name = "sign_options")
@Data
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
}
