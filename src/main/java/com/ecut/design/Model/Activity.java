package com.ecut.design.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

/**
 * 活动表
 */
@Entity
@Table(name = "activity")
@Data
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


}

