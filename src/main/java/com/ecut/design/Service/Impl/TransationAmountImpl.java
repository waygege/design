package com.ecut.design.Service.Impl;


import com.ecut.design.Config.util.PageableUtil;
import com.ecut.design.Model.TransationAmount;
import com.ecut.design.Model.User;
import com.ecut.design.Repository.TransationAmountRepository;
import com.ecut.design.Service.TransationAmountService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TransationAmountImpl implements TransationAmountService {

    @Autowired
    TransationAmountRepository transationAmountRepository;
    @Autowired
    PageableUtil pageableUtil;

    @ApiOperation ("添加消费纪录")
    public String  insertTransationAmount(TransationAmount transationAmount){
        Long currentUserId =( (User) SecurityUtils.getSubject().getSession().getAttribute("user")).getId ();
        transationAmount.setUserId (currentUserId);
        transationAmountRepository.save (transationAmount);
        return "success";
    }

    @ApiOperation ("查看消费纪录")
    public Page<TransationAmount>  findAllTransationAmount(TransationAmount transationAmount){
        Pageable pageable=pageableUtil.getPageable (transationAmount.getPageExample ());
      //  return transationAmountRepository.;
        return null;
    }
}
