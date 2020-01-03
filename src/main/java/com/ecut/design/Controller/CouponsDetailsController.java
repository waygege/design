package com.ecut.design.Controller;

import com.ecut.design.Model.CouponsDetails;
import com.ecut.design.Service.CouponsDetailsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/couponsDetails")
@Api(value = "优惠卷模块",tags = "优惠卷模块")
public class CouponsDetailsController {
    @Autowired
    CouponsDetailsService couponsDetailsService;



    @ApiOperation ("给用户发放优惠卷")
    @PutMapping("/sendCouponsDetails")
    public String sendCouponsDetails(Long couponsId,Long[] userIds){

        return  couponsDetailsService.sendCouponsDetails (couponsId,userIds);
    }

    @ApiOperation("核销优惠卷")
    @PutMapping("/updateCouponsDetails")
    public String updateCouponsDetails(Long id){

        return couponsDetailsService.updateCouponsDetails (id);
    }

    @ApiOperation ("查看优惠卷")
    @GetMapping("/findAllCouponsDetails")
    public List<CouponsDetails> findAllCouponsDetails(){
        return couponsDetailsService.findAllCouponsDetails ();
    }

}
