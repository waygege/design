package com.ecut.design.Service.Impl;

import com.ecut.design.Config.util.PageableUtil;
import com.ecut.design.Model.Activity;
import com.ecut.design.Model.Options;
import com.ecut.design.Repository.ActivityRepository;
import com.ecut.design.Repository.OptionRepository;
import com.ecut.design.Service.ActivityService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ActivityImpl implements ActivityService {

    @Autowired
    ActivityRepository activityRepository;
    @Autowired
    OptionRepository optionRepository;
    @Autowired
    PageableUtil pageableUtil;

    @ApiOperation ("添加活动")
    @Override
    public String insertActivity(Activity activity){
        activity= IsEnable (activity);
        activityRepository.save (activity);
        for (Options options:activity.getOptionsSet ()) {
            options.setActivityId (activity.getId ());
            optionRepository.save (options);
        }
        return "success";
    }

    @ApiOperation ("更新活动")
    @Override
    public String updateActivity(Activity activity){
        activity= IsEnable (activity);
        activityRepository.save (activity);
        for (Options option:activity.getOptionsSet ()) {
            optionRepository.save (option);
        }
        return "success";
    }

   @ApiOperation ("删除活动")
   @Override
    public String deleteActivity(Long id ){
        activityRepository.deleteById (id);
        optionRepository.deleteByActivityId (id);
        return "success";
   }

   @ApiOperation ("查找单个活动详情")
   @Override
    public Activity findActiviytById(Long id){
        Activity activity=activityRepository.findActivityById (id);
       activity= IsEnable (activity);
        return activity;
   }

   @ApiOperation ("查找活动")
   public Page<Activity> findActivitys(Activity activity){
       ExampleMatcher matcher=ExampleMatcher.matching ()
               .withMatcher ("activityName",ExampleMatcher.GenericPropertyMatchers.contains())
               .withIgnorePaths ("id")
               .withIgnorePaths ("activityTypeId");
       Example<Activity> activityExample=Example.of (activity,matcher);
       Pageable pageable=pageableUtil.getPageable (activity.getPageExample ());
       Page<Activity> page=activityRepository.findAll (activityExample,pageable);
       List<Activity> activityList=page.getContent ();
       for(Activity activityUpdate :activityList ){
           activityUpdate=IsEnable (activityUpdate);
       }
       Page<Activity> pageAfter=new PageImpl (activityList,new PageableUtil ().getPageable (activity.getPageExample ()),activityList.size ());
        return pageAfter;
   }

    /**
     * 判断活动状态
     * @param activity
     * @return
     */

    public  Activity  IsEnable( Activity activity) {
        if (activity.getActivityEnd()!=null&&activity.getActivityStart()!=null){
            if(LocalDate.now().isAfter(activity.getActivityEnd())){
                activity.setStatus(Activity.ACTIVITY_OVERDUE_);
            }
            if (LocalDate.now().isBefore(activity.getActivityEnd())&&LocalDate.now().isAfter(activity.getActivityStart())){
                activity.setStatus(Activity.ACTIVITY__HAVING);
            }
            if(LocalDate.now().isBefore(activity.getActivityStart())){
                activity.setStatus(Activity.ACTIVITY_NOT_START);
            }
        }else{
            throw new RuntimeException("开始日期或结束日期为空");
        }
        activityRepository.save ( activity);
        return  activity;
    }

}
