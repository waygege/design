package com.ecut.design.Service;

import com.ecut.design.Model.MemberIntegral;
import io.swagger.annotations.ApiOperation;

public interface MemberIntegralService {

    @ApiOperation("更新会员积分信息")
    public String updateMemberIntegral(MemberIntegral memberIntegral);
}
