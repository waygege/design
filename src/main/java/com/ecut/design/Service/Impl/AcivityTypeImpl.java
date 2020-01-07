package com.ecut.design.Service.Impl;


import com.ecut.design.Config.util.PageableUtil;
import com.ecut.design.Model.ActivityType;
import com.ecut.design.Repository.ActivityTypeRepository;
import com.ecut.design.Service.ActivityTypeService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;



@Service
public class AcivityTypeImpl implements ActivityTypeService {

    @Autowired
    ActivityTypeRepository activityTypeRepository;

    @Autowired
    PageableUtil pageableUtil;

    @ApiOperation ("添加活动类型")
    @Override
    public String insertActivityType (ActivityType activityType){
        activityTypeRepository.save (activityType);
        return "success";
    }

    @ApiOperation ("删除活动类型")
    public String deleteActivityType (Long id){
      activityTypeRepository.deleteById (id);
        return "success";
    }

    @ApiOperation ("更新活动类型")
    public String updateActivityType (ActivityType activityType){
        activityTypeRepository.save (activityType);
        return "success";
    }

    @ApiOperation ("查询活动类型")
    public Page<ActivityType> findByActivityTypes (ActivityType activityType){
         Pageable pageable=pageableUtil.getPageable (activityType.getPageExample ());
        return activityTypeRepository.findAll (pageable);
    }


}
