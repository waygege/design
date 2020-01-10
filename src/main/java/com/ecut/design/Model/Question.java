package com.ecut.design.Model;


import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;

/**
 * 问题表
 */
@Entity
@Table(name = "question")
@Data
public class Question {
    @Id
    @GeneratedValue
    private Long id;
    /**
     * 问题
     */
    @ApiModelProperty(value = "question",example = "问题",required = true)
    private String  question;
    /**
     * 回答内容
     */
    @ApiModelProperty(value = "replyContent",example = "回答内容",required = true)
    private String  replyContent;


}
