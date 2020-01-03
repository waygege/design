package com.ecut.design.Service;

import com.ecut.design.Model.Coupons;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;

public interface CouponsService {

    @ApiOperation("查询优惠卷")
    public Page<Coupons> findeCoupons(Coupons coupons);

    @ApiOperation ("删除优惠卷")
    public String deleteCoupons(Long[] ids);

    @ApiOperation ("更新优惠卷")
    public String updateCoupons(Coupons coupons);

    @ApiOperation ("添加优惠卷")
    public String insertCoupons(Coupons coupons);

    @ApiOperation ("优惠卷的上下架")
    public String upOrDownCoupons(Long id ,String status);

    @ApiOperation ("发放优惠卷")

    public String sendCouponsDetails(Coupons coupons);


}
