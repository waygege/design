package com.ecut.design.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 餐厅
 */
@Entity
@Table(name = "restaurant")
public class Restaurant implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    /**
     * 餐馆名
     */
    private String name;
    /**
     * 维度
     */
    private Double latitude;
    /**
     * 经度
     */
    private Double longitude;
    /**
     * 联系电话
     */
    private String contactPhone;
    /**
     * 详细地址
     */
    private String address;
    /**
     * 营业时间
     */
    private String businessHours;
    /**
     * 最后点餐时间
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime lastOrderTime;

    @Transient
    @ApiModelProperty(hidden=true)
    @JsonIgnore
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

    public Double getLatitude () {
        return latitude;
    }

    public void setLatitude (Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude () {
        return longitude;
    }

    public void setLongitude (Double longitude) {
        this.longitude = longitude;
    }

    public String getContactPhone () {
        return contactPhone;
    }

    public void setContactPhone (String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public String getAddress () {
        return address;
    }

    public void setAddress (String address) {
        this.address = address;
    }

    public String getBusinessHours () {
        return businessHours;
    }

    public void setBusinessHours (String businessHours) {
        this.businessHours = businessHours;
    }

    public LocalDateTime getLastOrderTime () {
        return lastOrderTime;
    }

    public void setLastOrderTime (LocalDateTime lastOrderTime) {
        this.lastOrderTime = lastOrderTime;
    }

    public PageExample getPageExample () {
        return pageExample;
    }

    public void setPageExample (PageExample pageExample) {
        this.pageExample = pageExample;
    }
}
