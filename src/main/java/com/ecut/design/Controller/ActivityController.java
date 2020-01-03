package com.ecut.design.Controller;

import com.ecut.design.Model.Activity;
import com.ecut.design.Model.ActivityType;
import com.ecut.design.Service.ActivityService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/activity")
@Api(value ="活动模块",tags = "活动模块")
public class ActivityController {
    @Autowired
    ActivityService activityService;


    @PostMapping("/insertActivity")
    @ApiOperation ("添加活动")
    public String insertActivity(Activity activity){

    return activityService.insertActivity (activity);
    }

    @PutMapping("/updateActivity")
    @ApiOperation ("更新活动")
    public String updateActivity(Activity activity){

        return activityService.updateActivity (activity);
    }

    @DeleteMapping("/deleteActivity")
    @ApiOperation ("删除活动")
    public String deleteActivity(Long id){

        return activityService.deleteActivity (id);
    }


    @GetMapping("/findActivityById")
    @ApiOperation("查找单个活动详情")
    public Activity findActivityById(Long id){

        return activityService.findActiviytById (id);
    }

    @GetMapping("/findActivitys")
    @ApiOperation ("查找活动")
    public Page<Activity> findActivity(Activity activity){

        return activityService.findActivitys (activity);
    }
}
