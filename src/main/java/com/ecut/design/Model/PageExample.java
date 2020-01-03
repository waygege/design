package com.ecut.design.Model;

import io.lettuce.core.GeoArgs;
import org.springframework.data.domain.Sort;


import javax.persistence.Entity;

/**
 * 分页对象
 */
public class PageExample {

    /**
     * 页码
     */
    private int pageNumber;
    /**
     * 页大小
     */
    private int pageSize;

    /**
     * 排序类型
     */
   private String sortType;
    /**
     *
     */
   private String sortableFields;

    public int getPageNumber () {
        return pageNumber;
    }

    public void setPageNumber (int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getPageSize () {
        return pageSize;
    }

    public void setPageSize (int pageSize) {
        this.pageSize = pageSize;
    }

    public String getSortType () {
        return sortType;
    }

    public void setSortType (String sortType) {
        this.sortType = sortType;
    }

    public String getSortableFields () {
        return sortableFields;
    }

    public void setSortableFields (String sortableFields) {
        this.sortableFields = sortableFields;
    }
}
