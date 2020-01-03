package com.ecut.design.Controller;

import com.ecut.design.Model.Restaurant;
import com.ecut.design.Service.ResaturantService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(value = "餐厅模块RestaurantController",tags = "餐馆模块")
@RequestMapping("/restaurant")
public class RestaurantController {

    @Autowired
    ResaturantService resaturantService;

    @ApiOperation ("添加餐厅")
    @PostMapping("/insertRestaurant")
    public String insertRestaurant(@RequestBody Restaurant resaturant){

        return resaturantService.insertRestaurant (resaturant);
    }

    @ApiOperation ("查询餐厅")
    @GetMapping("/searchRestaurants")
    public Page<Restaurant> searchRestaurant(@RequestBody Restaurant restaurant){

        return resaturantService.searchRestaurants (restaurant);
    }

    @ApiOperation ("更新餐厅信息")
    @PutMapping("/updateRestaurant")
    public String updateRestaurant(@RequestBody Restaurant restaurant){

        return resaturantService.updateRestaurant (restaurant);
    }

    @ApiOperation ("删除餐厅信息")
    @DeleteMapping("/deleteRestaurant")
    public String deleteRestaurant(Long id){

        return resaturantService.deleteRestaut (id);
    }


}
