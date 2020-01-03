package com.ecut.design.Service.Impl;

import com.ecut.design.Model.Evaluate;
import com.ecut.design.Repository.EvaluateRepository;
import com.ecut.design.Repository.RestaurantRepository;
import com.ecut.design.Repository.UserRepository;
import com.ecut.design.Service.EvaluateService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EvaluateImpl implements EvaluateService {

    @Autowired
    EvaluateRepository evaluateRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    RestaurantRepository restaurantRepository;

    @ApiOperation ("发布评价")
    @Override
    public String sendEvaluate(Evaluate evaluate){
        //获得当前用户
       // evaluate.setUserId ();

        evaluateRepository.save (evaluate);
        return "success";
    }

    @ApiOperation ("查看评价")
    @Override
    public Evaluate findEvalutaById(Long id){
        Evaluate evaluate=    evaluateRepository.getOne (id);
        evaluate.setRestaurant (restaurantRepository.getOne (evaluate.getRestaurantId ()));
        evaluate.setUser(userRepository.getOne (evaluate.getUserId ()));
        return evaluate;
    }

    @ApiOperation ("查看所有评价")
    @Override
    public List<Evaluate> findEvaluate(Evaluate evaluate){

        //
        return null;
    }

}
