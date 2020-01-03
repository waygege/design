package com.ecut.design.Controller;

import com.ecut.design.Model.Sign;
import com.ecut.design.Service.SignService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sign")
@Api(tags = "报名管理模块",value = "报名管理模块")
public class SignController {

    @Autowired
    SignService signService;

    @ApiOperation("活动报名")
    @PostMapping("/signActivity")
    public String signActity(@RequestBody Sign sign){

        return signService.signActity (sign);
    }

    @ApiOperation ("查看报名详情")
    @GetMapping("/showSignDetail")
    public Sign showSginDetail(Long id){

        return signService.showSginDetail (id);
    }

    @ApiOperation ("查看活动报名")
    @GetMapping("/findAllSigns")
    public Page<Sign> findAllSigns(@RequestBody Sign sign){

        return signService.findAllSigns (sign);
    }


}
