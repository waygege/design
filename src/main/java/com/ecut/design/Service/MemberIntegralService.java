package com.ecut.design.Service;

import com.ecut.design.Model.MemberIntegral;
import io.swagger.annotations.ApiOperation;

import java.util.List;

public interface MemberIntegralService {

    @ApiOperation("更新会员积分信息")
    public String updateMemberIntegral(MemberIntegral memberIntegral);

    @ApiOperation ("查看所有会员信息")
    public List<MemberIntegral> findAll();

}
