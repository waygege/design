package com.ecut.design.Service.Impl;

import com.ecut.design.Model.MemberIntegral;
import com.ecut.design.Repository.MemberIntegralRepository;
import com.ecut.design.Service.MemberIntegralService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberIntegralImpl implements MemberIntegralService {

    @Autowired
    MemberIntegralRepository memberIntegralRepository;

    @ApiOperation ("更新会员积分信息")
    public String updateMemberIntegral(MemberIntegral memberIntegral){
        memberIntegralRepository.save (memberIntegral);
        return "successs";
    }

    @ApiOperation ("查看所有会员信息")
    public List<MemberIntegral> findAll(){

        return memberIntegralRepository.findAll ();
    }
}
