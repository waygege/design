package com.ecut.design.Service.Impl;

import com.ecut.design.Model.Sign;
import com.ecut.design.Model.User;
import com.ecut.design.Repository.ActivityRepository;
import com.ecut.design.Repository.SignOptionsRepository;
import com.ecut.design.Repository.SignRepository;
import com.ecut.design.Repository.UserRepository;
import com.ecut.design.Service.SignService;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SignImpl implements SignService {

    @Autowired
    SignOptionsRepository signOptionRepository;
    @Autowired
    SignRepository signRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    ActivityRepository activityRepository;

    @ApiOperation ("活动报名")
    @Override
    public String signActity(Sign sign){
        Long currentUserId =( (User) SecurityUtils.getSubject().getSession().getAttribute("user")).getId ();
        sign.setUserId (currentUserId);
        signRepository.save (sign);
        return "success";
    }

    @ApiOperation ("查看报名详情")
    @Override
    public Sign showSginDetail(Long id){
        Sign sign=signRepository.getOne (id);
        sign.setUser (userRepository.getOne (sign.getUserId ()));
        sign.setActivity (activityRepository.getOne (sign.getActivityId ()));
        sign.setSignOptions (signOptionRepository.findSignOptionsBySignId(sign.getId ()));
        return sign;
    }

    @ApiOperation ("条件查看活动报名")
    @Override
    public Page<Sign> findAllSigns(Sign sign){

        return null;
    }


}
