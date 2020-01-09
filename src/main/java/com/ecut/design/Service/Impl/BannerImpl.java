package com.ecut.design.Service.Impl;

import com.ecut.design.Config.util.PageableUtil;
import com.ecut.design.Model.Banner;
import com.ecut.design.Model.Dish;
import com.ecut.design.Repository.BannerRepository;
import com.ecut.design.Service.BannerService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.time.LocalDateTime;
import java.util.List;

@Service
public class BannerImpl implements BannerService {

    @Autowired
    BannerRepository bannerRepository;
    @Autowired
    PageableUtil pageableUtil;

    @ApiOperation ("新建广告")
    @Override
    public String insertBanner(Banner banner){

        banner.setStatus(Banner.STATUS_UNSHELVE);
        bannerRepository.save (banner);
        return "success";
    }

    @ApiOperation ("删除广告")
    @Override
    public String deleteBanner(Long[] ids){

        bannerRepository.deleteBannersByIds(ids);
        return "success";
    }


    @ApiOperation ("更新广告")
    @Override
    public  String updateBanner(Banner banner){
        bannerRepository.save (banner);
        return "success";
    }

    @ApiOperation ("上下架广告")
    @Override
    public String upOrDownBanner(Long id,String status){

        Banner banner=bannerRepository.findById (id).get ();
        banner=isValidBanner (banner);
        if (!Banner.STATUS_EXPIRED.equals (banner.getStatus ()))
        {
            banner.setStatus (status);
        }
        banner=isValidBanner (banner);
        bannerRepository.save (banner);
        return "success";
    }

    @ApiOperation("查找展示广告")
    @Override
    public List<Banner> findShowBanners(){
    List<Banner> bannerList=  bannerRepository.findShowBanners();
    for (Banner banner:bannerList){
        banner=isValidBanner (banner);
    }
    return bannerList;

    }

    @ApiOperation ("查询广告")
    @Override
    public Page<Banner> findBanner(Banner banner){
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withMatcher ("bannerTitle",ExampleMatcher.GenericPropertyMatchers.contains())
                .withIgnorePaths("status")
                //因为id是基本类型所以他默认为0会导致查询为空
                .withIgnorePaths("id")
                .withIgnorePaths("bannerPicture")
                .withIgnorePaths ("position")
                .withIgnorePaths ("jumpLink");
        Example<Banner> exampleDish = Example.of(banner ,matcher);
        Pageable pageable=pageableUtil.getPageable (banner.getPageExample ());

        Page<Banner> pageBefor =bannerRepository.findAll (exampleDish,pageable);
        for (Banner banner1:pageBefor.getContent ()){
            banner1=isValidBanner (banner1);
            bannerRepository.save (banner1);
        }
     return  pageBefor;
    }


    @ApiOperation ("判断广告状态")
    public Banner isValidBanner(Banner banner){
        if (LocalDateTime.now ().isAfter (banner.getEndTime ())){
            banner.setStatus (Banner.STATUS_EXPIRED);
        }
        if (LocalDateTime.now ().isAfter (banner.getStartTime ())
          && LocalDateTime.now ().isBefore (banner.getEndTime ())
          &&Banner.STATUS_UP.equals (banner.getStatus ())
        )
        {
           banner.setStatus (Banner.STATUS_ONSHOW);
        }

        return banner;
    }

}
