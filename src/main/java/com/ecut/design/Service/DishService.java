package com.ecut.design.Service;

import com.ecut.design.Model.Dish;

import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface DishService {

    @ApiOperation ("添加菜品")
    public String insertDish(Dish dish);

    @ApiOperation ("查询菜品")
    public Page<Dish> searchDishs(Dish dish);

    @ApiOperation ("删除菜品")
    public String deleteDishs(Long[] ids);

    @ApiOperation ("更新菜品状态")
    public  String updateDishsStatus(Long[] ids, String status);

    @ApiOperation ("更新菜品")
    public  String updateDish(Dish dish);



}
