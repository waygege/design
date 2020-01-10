package com.ecut.design.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "article")
@Data
public class Article {
    @Id
    @GeneratedValue
    private Long id;
    /*
     * 平台协议
     * */
    @ApiModelProperty(value = "agreement", required = true, position = 2, example = "平台协议")
    private String agreement;

    /*
     * 关于我们
     * */
    @ApiModelProperty(value = "aboutUs", required = true, position = 2, example = "关于我们")
    private String aboutUs;

    @Transient
    @ApiModelProperty(hidden=true)
    private PageExample pageExample;

   }
