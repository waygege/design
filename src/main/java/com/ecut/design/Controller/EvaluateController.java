package com.ecut.design.Controller;

import com.ecut.design.Model.Evaluate;
import com.ecut.design.Service.EvaluateService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/evaluate")
@Api(value = "评价管理模块",tags = "评价管理模块")
public class EvaluateController {
    @Autowired
    EvaluateService evaluateService;

    @ApiOperation("发布评价")
    @PostMapping("/sendEvaluate")
    public String sendEvaluate(@RequestBody Evaluate evaluate){

        return  evaluateService.sendEvaluate (evaluate);
    }

    @ApiOperation ("查看评价")
    @GetMapping("/findEvaluateById")
    public Evaluate findEvalutaById(Long id){

        return evaluateService.findEvalutaById (id);
    }

    @ApiOperation ("查看所有评价")
    @GetMapping("/findEvaluate")
    public List<Evaluate> findEvaluate(@RequestBody Evaluate evaluate){

        return evaluateService.findEvaluate (evaluate);
    }
}
