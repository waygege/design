package com.ecut.design.Controller;

import com.ecut.design.Model.PageExample;
import com.ecut.design.Model.Question;
import com.ecut.design.Service.QuestionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/question")
@Api(value = "问题管理模块",tags = "问题管理模块")
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @ApiOperation ("添加问题")
    @PostMapping("/insertQuestion")
    public String insertQuestion(@RequestBody Question question){
        return questionService.insertQuestion (question);
    }

    @ApiOperation ("更新问题")
    @PutMapping("/updateQuestion")
    public String updateQuestion(@RequestBody Question question){

        return questionService.updateQuestion (question);
    }

    @ApiOperation ("删除问题")
    @DeleteMapping("/deleteQuestion")
    public String deleteQuestion(Long[] ids){

        return questionService.deleteQuestion (ids);
    }

    @ApiOperation("查找问题")
    @GetMapping("/findAllQuestions")
    public Page<Question> findAllQuestions(@RequestBody PageExample pageExample){

        return  questionService.findAllQuestions (pageExample);
    }
}
