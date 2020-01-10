package com.ecut.design.Service.Impl;

import com.ecut.design.Config.util.PageableUtils.PageableUtil;
import com.ecut.design.Model.Evaluate;
import com.ecut.design.Model.User;
import com.ecut.design.Repository.EvaluateRepository;
import com.ecut.design.Repository.RestaurantRepository;
import com.ecut.design.Repository.UserRepository;
import com.ecut.design.Service.EvaluateService;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class EvaluateImpl implements EvaluateService {

    @Autowired
    EvaluateRepository evaluateRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    RestaurantRepository restaurantRepository;
    @Autowired
    PageableUtil pageableUtil;

    @ApiOperation ("发布评价")
    @Override
    public String sendEvaluate(Evaluate evaluate){
        //获得当前用户
       // evaluate.setUserId ();
        Long currentUserId =( (User) SecurityUtils.getSubject().getSession().getAttribute("user")).getId ();
         evaluate.setUserId (currentUserId);
         evaluate.setCommentTime (LocalDateTime.now ());
        evaluateRepository.save (evaluate);
        return "success";
    }

    @ApiOperation ("查看评价")
    @Override
    public Evaluate findEvalutaById(Long id){
        Evaluate evaluate=    evaluateRepository.findById (id).get ();
        evaluate.setRestaurant (restaurantRepository.findById (evaluate.getRestaurantId ()).get ());
        evaluate.setUser(userRepository.findById (evaluate.getUserId ()).get ());
        return evaluate;
    }

    @ApiOperation ("条件查找评价")
    @Override
    public Page<Evaluate> findEvaluates(Evaluate evaluate){
       evaluate.setUser (userRepository.findById (evaluate.getUserId ()).get ());
       evaluate.setRestaurant (restaurantRepository.findById (evaluate.getRestaurantId ()).get ());
        Pageable pageable=pageableUtil.getPageable (evaluate.getPageExample ());
       List<Evaluate> evaluateList= evaluateRepository.findEvaluates2 (evaluate.getUser ().getUsername (),evaluate.getRestaurant ().getName (),evaluate.getCommentStartTime (),evaluate.getCommentEndTime (),pageable);
        Page<Evaluate> evaluatePage=new PageImpl<Evaluate> (evaluateList,pageable,evaluateList.size ());
        return evaluatePage;

    }

}
