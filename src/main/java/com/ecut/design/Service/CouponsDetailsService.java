package com.ecut.design.Service;

import com.ecut.design.Model.CouponsDetails;
import io.swagger.annotations.ApiOperation;

import java.util.List;

public interface CouponsDetailsService {




    @ApiOperation ("发放给用户优惠卷")
    public String sendCouponsDetails(Long couponsId,Long[] userIds);

    @ApiOperation("核销优惠卷")
    public String updateCouponsDetails(Long id );

    @ApiOperation ("查看优惠卷")
    public List<CouponsDetails> findAllCouponsDetails();
}
