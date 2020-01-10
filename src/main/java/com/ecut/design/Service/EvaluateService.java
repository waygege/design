package com.ecut.design.Service;

import com.ecut.design.Model.Evaluate;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;

import java.util.List;

public interface EvaluateService {

    @ApiOperation("发布评价")
    public String sendEvaluate(Evaluate evaluate);

    @ApiOperation ("查看评价")
    public Evaluate findEvalutaById(Long id);

    @ApiOperation ("条件查找评价")
    public Page<Evaluate> findEvaluates(Evaluate evaluate);
}
