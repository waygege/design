package com.ecut.design.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 餐厅
 */
@Entity
@Table(name = "restaurant")
@Data
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


}
