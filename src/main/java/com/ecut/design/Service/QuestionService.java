package com.ecut.design.Service;

import com.ecut.design.Model.PageExample;
import com.ecut.design.Model.Question;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;

public interface QuestionService {

    @ApiOperation ("添加问题")
    public String insertQuestion(Question question);

    @ApiOperation ("更新问题")
    public String updateQuestion(Question question);

    @ApiOperation ("删除问题")
    public String deleteQuestion(Long[] ids);

    @ApiOperation("查找问题")
    public Page<Question> findAllQuestions(PageExample pageExample);
}
