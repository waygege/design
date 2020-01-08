package com.ecut.design.Controller;

import com.ecut.design.Model.Coupons;
import com.ecut.design.Service.CouponsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/coupons")
@Api(value = "优惠卷种类管理模块",tags = "优惠卷种类管理模块")
public class CouponsController {
    @Autowired
    CouponsService couponsService;



    @ApiOperation ("删除优惠卷")
    @DeleteMapping("/deleteCoupons")
    public String deleteCoupons(@RequestParam("ids") Long[] ids){

        return couponsService.deleteCoupons (ids);
    }

    @ApiOperation ("更新优惠卷")
    @PutMapping("/updateCoupons")
    public String updateCoupons(@RequestBody Coupons coupons){

        return couponsService.updateCoupons (coupons);
    }

    @ApiOperation ("添加优惠卷")
    @PostMapping("/insertCoupons")
    public String insertCoupons(@RequestBody Coupons coupons){
        return couponsService.insertCoupons (coupons);
    }

    @ApiOperation ("优惠卷的上下架")
    @PutMapping("/upOrDownCoupons")
    public String upOrDownCoupons(Long id ,String status){

        return couponsService.upOrDownCoupons (id,status);
    }

    @ApiOperation("查询优惠卷")
    @GetMapping("/findCoupons")
    public Page<Coupons> findeCoupons(@RequestBody Coupons coupons){
        return couponsService.findeCoupons(coupons);
    }


    @ApiOperation ("发放优惠卷")
    @PostMapping("/sendCouponsDetails")
    public String sendCouponsDetails(@RequestBody Coupons coupons){

        return couponsService.sendCouponsDetails (coupons);
    }



}
