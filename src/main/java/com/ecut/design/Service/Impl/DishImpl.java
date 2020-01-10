package com.ecut.design.Service.Impl;

import com.ecut.design.Config.util.PageableUtils.PageableUtil;
import com.ecut.design.Model.Dish;

import com.ecut.design.Repository.DishRepository;
import com.ecut.design.Service.DishService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class DishImpl implements DishService {

    @Autowired
    DishRepository dishRepository;
    @Autowired
    PageableUtil pageableUtil;

    @ApiOperation ("添加菜品")
    public String insertDish(Dish dish){
        dish=IsEnable(dish);
        dishRepository.save (dish);
        return "success";
    }

    @ApiOperation ("查询菜品")
    public Page<Dish> searchDishs(Dish dish ){

        ExampleMatcher matcher = ExampleMatcher.matching()
                .withMatcher ("title",ExampleMatcher.GenericPropertyMatchers.contains())
                //因为id是基本类型所以他默认为0会导致查询为空
                  .withIgnorePaths("id");
        Example<Dish> exampleDish = Example.of(dish ,matcher);
        Pageable pageable=pageableUtil.getPageable (dish.getPageExample ());

        Page<Dish> pageBefor = dishRepository.findAll (exampleDish,pageable);
        List<Dish> dishes = pageBefor.getContent ();
        for (Dish dishUpdate:dishes){
            dishUpdate= IsEnable(dishUpdate);
           dishRepository. save (dishUpdate);
        }
        Page<Dish> pageAfter = new PageImpl (dishes, new PageableUtil ().getPageable (dish.getPageExample ()), dishes.size ());
        return  pageAfter;
    }

    @ApiOperation ("删除菜品")
    public String deleteDishs(Long[] ids ){
        dishRepository.deleteByDishIds (ids);
        return "success";
    }

    @ApiOperation ("上下架菜品")
    public String updateDishsStatus(Long[] ids,String status){

        Long[] Status_On_ids=new Long[ids.length];
        int i=0;//上架的商品
        Long[] Status_Not_Onids=new Long[ids.length];
        int j=0;//下架的商品
        List<Dish> dishList=dishRepository.findDishsByIds(ids);
        for (Dish dish:dishList) {
            if ("上架".equals (status)) {
                //如果这个已过期就不能上架
                if (!dish.getStatus ().equals (Dish.STATUS_OVERDUE)) {
                    Status_On_ids[i]=dish.getId ();
                    i++;
                }else{
                    continue;
                }
            }
            if ("下架".equals (status)) {
                Status_Not_Onids[j]=dish.getId ();
                j++;
            }
        }
        dishRepository.updateDishsStatus (Status_Not_Onids,Dish.STATUS_NOT_ON);
        dishRepository.updateDishsStatus (Status_On_ids,Dish.STATUS_ON);
        return "success";

    }

    @ApiOperation ("更新菜品")
    @Override
    public String updateDish (Dish dish) {
        dishRepository.save (dish);
        return "success";
    }





    @ApiOperation ("判断过期")
    public Dish IsEnable (Dish dish) {
        if (LocalDateTime.now ().isAfter (dish.getEndDateTime ())) {
            dish.setStatus (Dish.STATUS_OVERDUE);
        } else if (LocalDateTime.now ().isBefore (dish.getStartDateTime ())) {
            //如果没过期的产品下架的话他就不能设置没没过期
            if (!(dish.getStatus ().equals (Dish.STATUS_NOT_ON) || dish.getStatus ().equals (Dish.STATUS_ON))) {
                dish.setStatus (Dish.STATUS_NO_START);
            }
        } else {
            if (!(dish.getStatus ().equals (Dish.STATUS_NOT_ON) || dish.getStatus ().equals (Dish.STATUS_ON))) {
                dish.setStatus (Dish.STATUS_START);
            }
        }
        return dish;
    }

    @ApiOperation ("判断是否在客户端显示（是否上架）")
    public List<Dish> findViewDish (List<Dish> dishList) {
        List<Dish> dishViewList = new ArrayList<> ();
        for (Dish dish : dishList) {
            dish = IsEnable (dish);
            if ((dish.getStatus ().equals (Dish.STATUS_ON)
                    && LocalDateTime.now ().isAfter (dish.getStartDateTime ()) || LocalDateTime.now ().equals (dish.getStartDateTime ())
                    && LocalDateTime.now ().isBefore (dish.getEndDateTime ())) || LocalDateTime.now ().equals (dish.getEndDateTime ())) {
                dishViewList.add (dish);
            }
        }
        return dishViewList;


    }
}
