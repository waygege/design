package com.ecut.design.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

/**
   * 活动报名表
 */
@Entity
@Table(name = "sign")
@Data
public class Sign {
      @Id
      @GeneratedValue
        private Long  id;
        /**
         * 用户Id
         */

        private Long userId;

        /**
         *报名的用户
         */
        @Transient
        @ApiModelProperty(hidden=true)
        private User user;

        /**
         * 报名的用户名
         */
        @Transient
        @ApiModelProperty(hidden=true)
        private String name;
        /**
         * 报名的用户手机号
         */
        @Transient
        @ApiModelProperty(hidden=true)

        private String phone;


        /**
         * 选项信息
         */
        @Transient
        @ApiModelProperty(hidden=true)
        private List<SignOptions> signOptions;
        /**
         * 活动Id
         *
         */
        private Long activityId;

        /**
         * 活动名
         *
         */
        @Transient
        @ApiModelProperty(hidden=true)
        private String activityName;
        /**
         * 活动开始时间
         */
        @Transient
        @ApiModelProperty(hidden=true)
        private LocalDate activityStart;


        /**
         * 活动结束时间
         */
        @Transient
        @ApiModelProperty(hidden=true)
        private LocalDate activityEnd;
        /**
         * 活动对象
         */

        @Transient
        @ApiModelProperty(hidden=true)
        private Activity activity;

        /**
         * 备注
         */
        @ApiModelProperty(value = "remark",example = "备注",required = true)
        private String  remark;


}
