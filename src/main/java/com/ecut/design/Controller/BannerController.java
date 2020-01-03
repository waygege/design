package com.ecut.design.Controller;

import com.ecut.design.Model.Banner;
import com.ecut.design.Service.BannerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/banner")
@Api(value = "广告管理模块",tags = "广告管理模块")
public class BannerController {

   @Autowired
    BannerService bannerService;

    @ApiOperation("新建广告")
    @PostMapping("/insertBanner")
    public String insertBanner(@RequestBody Banner banner){
        return bannerService.insertBanner (banner);
    }

    @ApiOperation ("删除广告")
    @DeleteMapping("/deleteBanner")
    public String deleteBanner(Long[] ids){

        return bannerService.deleteBanner (ids);
    }

    @ApiOperation ("更新广告")
    @PutMapping("/updateBanner")
    public  String updateBanner(@RequestBody Banner banner){

        return bannerService.updateBanner (banner);
    }

    @ApiOperation ("上下架广告")
    @PutMapping("/upOrDownBanner")
    public String upOrDownBanner(Long id,String status){

        return bannerService.upOrDownBanner (id,status);
    }

    @ApiOperation("查找展示广告")
    @GetMapping("/findShowBanners")
    public List<Banner> findShowBanners(){

        return bannerService.findShowBanners ();
    }

    @ApiOperation ("查询广告")
    @GetMapping("/findBanner")
    public Page<Banner> findBanner(@RequestBody Banner banner){

        return bannerService.findBanner (banner);
    }
}
