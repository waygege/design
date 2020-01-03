package com.ecut.design.Model;


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
    private String  question;
    /**
     * 回答内容
     */
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
