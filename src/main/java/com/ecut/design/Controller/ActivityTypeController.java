package com.ecut.design.Controller;

import com.ecut.design.Model.Activity;
import com.ecut.design.Model.ActivityType;
import com.ecut.design.Service.ActivityTypeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(value = "活动类型",tags = "活动类型")
@RequestMapping("/activityType")
public class ActivityTypeController {
    @Autowired
    ActivityTypeService activityTypeService;

    @PostMapping("/insertActivityType")
    @ApiOperation ("添加活动类型")
    public String  insertActivityType(@RequestBody ActivityType activityType){

        return activityTypeService.insertActivityType (activityType);
    }

    @DeleteMapping("/deleteActivityType")
    @ApiOperation ("删除活动类型")
    public String deleteActivityTypeById(Long id){

        return activityTypeService.deleteActivityType (id);
    }

    @PutMapping("/updateActivityType")
    @ApiOperation ("更新活动类型")
    public String updateActivityType(@RequestBody ActivityType activityType){

        return activityTypeService.updateActivityType (activityType);
    }

    @GetMapping("/findActivitys")
    @ApiOperation ("查询活动类型")
    public Page<ActivityType> findActivitys(@RequestBody ActivityType activityType){

        return activityTypeService.findByActivityTypes (activityType);
    }



}
