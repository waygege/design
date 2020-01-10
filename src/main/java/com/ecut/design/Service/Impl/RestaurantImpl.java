package com.ecut.design.Service.Impl;

import com.ecut.design.Config.util.PageableUtils.PageableUtil;
import com.ecut.design.Model.Restaurant;
import com.ecut.design.Repository.RestaurantRepository;
import com.ecut.design.Service.ResaturantService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

@Service
public class RestaurantImpl implements ResaturantService {

    @Autowired
    RestaurantRepository restaurantRepository;
    @ApiOperation ("添加餐厅")
    @Override
    public String insertRestaurant (Restaurant restaurant) {
        restaurantRepository.save (restaurant);
        return "success";
    }
    @ApiOperation ("删除餐厅")
    @Override
    public String deleteRestaut (Long id) {
        restaurantRepository.deleteById (id);
        return "success";
    }

    @ApiOperation ("查询餐厅")
    @Override
    public Page<Restaurant> searchRestaurants (Restaurant restaurant) {

        ExampleMatcher matcher = ExampleMatcher.matching()
                .withMatcher ("name",ExampleMatcher.GenericPropertyMatchers.contains())
                .withIgnorePaths("latitude")
                .withIgnorePaths("longitude")
                //因为id是基本类型所以他默认为0会导致查询为空
                .withIgnorePaths("id");
        Example<Restaurant> exampleRestaurant = Example.of(restaurant ,matcher);
        Pageable pageable=new PageableUtil().getPageable (restaurant.getPageExample ());
        return restaurantRepository.findAll (exampleRestaurant,pageable );
    }
    @ApiOperation ("更新餐厅信息")
    @Override
    public String updateRestaurant (Restaurant restaurant) {
        return null;
    }
}
