package com.ecut.design.Service;

import com.ecut.design.Model.Banner;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;

import java.util.List;

public interface BannerService {

    @ApiOperation("新建广告")
    public String insertBanner(Banner banner);

    @ApiOperation ("删除广告")
    public String deleteBanner(Long[] ids);

    @ApiOperation ("更新广告")
    public  String updateBanner(Banner banner);

    @ApiOperation ("上下架广告")
    public String upOrDownBanner(Long id,String status);

    @ApiOperation("查找展示广告")
    public List<Banner> findShowBanners();

    @ApiOperation ("查询广告")
    public Page<Banner> findBanner(Banner banner);
}
