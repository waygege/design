package com.ecut.design.Service.Impl;

import com.ecut.design.Config.util.PageableUtil;
import com.ecut.design.Model.PageExample;
import com.ecut.design.Model.Question;
import com.ecut.design.Repository.QuestionRepository;
import com.ecut.design.Service.QuestionService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class QuestionImpl implements QuestionService {

    @Autowired
    QuestionRepository questionRepository;
    @Autowired
    PageableUtil pageableUtil;

    @ApiOperation ("添加问题")
    public String insertQuestion(Question question){
       questionRepository.save (question);
        return "success";
    }

    @ApiOperation ("更新问题")
    public String updateQuestion(Question question){
        questionRepository.save (question);
        return "success";
    }

    @ApiOperation ("删除问题")
    public String deleteQuestion(Long[] ids){
        questionRepository.deleteQuestionByids (ids);
        return "success";
    }

    @ApiOperation ("查找问题")
    public Page<Question> findAllQuestions(PageExample pageExample){
        Pageable pageable= pageableUtil.getPageable (pageExample);
        return  questionRepository.findAll (pageable);
    }
}
