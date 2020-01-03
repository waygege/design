package com.ecut.design.Model;


//import org.springframework.data.annotation.Id;


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
        private String name;
        /**
         * 图标
         */
        private String icon;
        /**
         * 序号
         */
        private Integer position;
        /**
         * 上一级分类Id
         */
        private  Long categoryId;
        /**
         * 上一级分类
         */
        @Transient
        private Category parentCategory;

        @Transient
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
