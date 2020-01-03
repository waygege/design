package com.ecut.design.Service;

import com.ecut.design.Model.ActivityType;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;

public interface ActivityTypeService {

    @ApiOperation("添加活动类型")
    public String insertActivityType (ActivityType activityType);

    @ApiOperation ("删除活动类型")
    public String deleteActivityType(Long id);

    @ApiOperation ("更新活动类型")
    public String updateActivityType(ActivityType activityType);

    @ApiOperation ("查询活动类型")
    public Page<ActivityType> findByActivityTypes(ActivityType activityType);
}
