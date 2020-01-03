package com.ecut.design.Service;

import com.ecut.design.Model.Activity;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;

public interface ActivityService {
    @ApiOperation("查找单个活动详情")
    public Activity findActiviytById(Long id);

    @ApiOperation ("删除活动")
    public String deleteActivity(Long id);

    @ApiOperation ("更新活动")
    public String updateActivity(Activity activity);

    @ApiOperation ("添加活动")
    public String insertActivity(Activity activity);

    @ApiOperation ("查找活动")
    public Page<Activity> findActivitys(Activity activity);
}
