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
    @ApiModelProperty(value = "name",example = "餐馆名",required = true)
    private String name;
    /**
     * 维度
     */
    @ApiModelProperty(value = "latitude",example = "00.00",required = true)
    private Double latitude;
    /**
     * 经度
     */
    @ApiModelProperty(value = "latitude",example = "00.00",required = true)
    private Double longitude;
    /**
     * 联系电话
     */
    @ApiModelProperty(value = "contactPhone",example = "15727551385",required = true)
    private String contactPhone;
    /**
     * 详细地址
     */
    @ApiModelProperty(value = "address",example = "详细地址",required = true)
    private String address;
    /**
     * 营业时间
     */
    @ApiModelProperty(value = "businessHours",example = "12小时",required = true)
    private String businessHours;
    /**
     * 最后点餐时间
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "lastOrderTime",example = "20:00:00",required = true)
    private String lastOrderTime;

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

    public String getLastOrderTime () {
        return lastOrderTime;
    }

    public void setLastOrderTime (String lastOrderTime) {
        this.lastOrderTime = lastOrderTime;
    }

    public PageExample getPageExample () {
        return pageExample;
    }

    public void setPageExample (PageExample pageExample) {
        this.pageExample = pageExample;
    }
}
