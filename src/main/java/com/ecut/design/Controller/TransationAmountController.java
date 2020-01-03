package com.ecut.design.Controller;

import com.ecut.design.Model.TransationAmount;
import com.ecut.design.Service.TransationAmountService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transationAmount")
@Api(tags = "交易记录模块",value = "交易记录模块")
public class TransationAmountController {

    @Autowired
    TransationAmountService transationAmountService;

    @ApiOperation("添加消费纪录")
    @PostMapping("/insertTransationAmount")
    public String  insertTransationAmount(TransationAmount transationAmount){

        return transationAmountService.insertTransationAmount (transationAmount);
    }

    @ApiOperation("查看消费纪录")
    @GetMapping("/findAllTransationAmount")
    public Page<TransationAmount> findAllTransationAmount(@RequestBody TransationAmount transationAmount){

        return transationAmountService.findAllTransationAmount (transationAmount);
    }


}
