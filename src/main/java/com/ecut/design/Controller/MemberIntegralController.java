package com.ecut.design.Controller;

import com.ecut.design.Model.MemberIntegral;
import com.ecut.design.Service.MemberIntegralService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/memberIntegral")
@Api(tags = "会员积分管理模块",value = "会员积分管理模块")
public class MemberIntegralController {

    @Autowired
    MemberIntegralService memberIntegralService;

    @ApiOperation("更新会员积分信息")
    @PutMapping("/updateMemberIntegral")
    public String updateMemberIntegral(@RequestBody MemberIntegral memberIntegral){

        return memberIntegralService.updateMemberIntegral (memberIntegral);
    }
}
