package com.ecut.design.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

@Entity
@Table(name = "article")
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

    public Long getId () {
        return id;
    }

    public void setId (Long id) {
        this.id = id;
    }

    public String getAgreement () {
        return agreement;
    }

    public void setAgreement (String agreement) {
        this.agreement = agreement;
    }

    public String getAboutUs () {
        return aboutUs;
    }

    public void setAboutUs (String aboutUs) {
        this.aboutUs = aboutUs;
    }

    public PageExample getPageExample () {
        return pageExample;
    }

    public void setPageExample (PageExample pageExample) {
        this.pageExample = pageExample;
    }
}
