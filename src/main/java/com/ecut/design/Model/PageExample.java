package com.ecut.design.Model;

import io.lettuce.core.GeoArgs;
import lombok.Data;
import org.springframework.data.domain.Sort;


import javax.persistence.Entity;

/**
 * 分页对象
 */
@Data
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


}
