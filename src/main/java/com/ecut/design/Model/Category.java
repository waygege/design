package com.ecut.design.Model;


//import org.springframework.data.annotation.Id;


import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 分类
 */

@Entity
@Table(name = "category")
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

        public Long getId () {
                return id;
        }

        public void setId (Long id) {
                this.id = id;
        }

        public String getName () {
                return name;
        }

        public void setName (String name) {
                this.name = name;
        }

        public String getIcon () {
                return icon;
        }

        public void setIcon (String icon) {
                this.icon = icon;
        }

        public Integer getPosition () {
                return position;
        }

        public void setPosition (Integer position) {
                this.position = position;
        }

        public Long getCategoryId () {
                return categoryId;
        }

        public void setCategoryId (Long categoryId) {
                this.categoryId = categoryId;
        }

        public Category getParentCategory () {
                return parentCategory;
        }

        public void setParentCategory (Category parentCategory) {
                this.parentCategory = parentCategory;
        }

        public PageExample getPageExample () {
                return pageExample;
        }

        public void setPageExample (PageExample pageExample) {
                this.pageExample = pageExample;
        }
}
