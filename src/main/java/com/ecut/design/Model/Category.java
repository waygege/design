package com.ecut.design.Model;


//import org.springframework.data.annotation.Id;


import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 分类
 */

@Entity
@Table(name = "category")
@Data
public class Category implements Serializable {


        @Id
        @GeneratedValue
        private Long id;
        /**
         * 名称
         */
        @ApiModelProperty(value = "name", required = true, position = 2, example = "名称")
        private String name;
        /**
         * 图标
         */
        @ApiModelProperty(value = "icon", required = true, position = 2, example = "图标地址")
        private String icon;
        /**
         * 序号
         */
        @ApiModelProperty(value = "position", required = true, position = 2, example = "1")
        private Integer position;
        /**
         * 上一级分类Id
         */
        @ApiModelProperty(value = "categoryId", required = true, position = 2, example = "1")
        private  Long categoryId;
        /**
         * 上一级分类
         */
        @Transient
        @ApiModelProperty(hidden=true)
        private Category parentCategory;

        @Transient
        @ApiModelProperty(hidden=true)
        private PageExample pageExample;

     }
