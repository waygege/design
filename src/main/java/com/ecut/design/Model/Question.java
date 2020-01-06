package com.ecut.design.Model;


import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

/**
 * 问题表
 */
@Entity
@Table(name = "question")
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

    public Long getId () {
        return id;
    }

    public void setId (Long id) {
        this.id = id;
    }

    public String getQuestion () {
        return question;
    }

    public void setQuestion (String question) {
        this.question = question;
    }

    public String getReplyContent () {
        return replyContent;
    }

    public void setReplyContent (String replyContent) {
        this.replyContent = replyContent;
    }
}
