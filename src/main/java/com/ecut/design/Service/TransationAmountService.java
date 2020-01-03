package com.ecut.design.Service;

import com.ecut.design.Model.TransationAmount;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;

public interface TransationAmountService {


    @ApiOperation ("添加消费纪录")
    public String  insertTransationAmount(TransationAmount transationAmount);

    @ApiOperation("查看消费纪录")
    public Page<TransationAmount> findAllTransationAmount(TransationAmount transationAmount);
}
