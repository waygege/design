package com.ecut.design.Controller;

import com.ecut.design.Config.util.PageableUtil;
import com.ecut.design.Model.Dish;

import com.ecut.design.Model.PageExample;
import com.ecut.design.Service.DishService;
import io.netty.util.internal.StringUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.*;

import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/dish")
@Api(value="菜品模块DishController",tags = "菜品模块")

public class DishController {
    @Autowired
    DishService dishService;

    @ApiOperation("添加菜品")
    @PostMapping("/insertDish")
    public String insertDish (@RequestBody Dish dish) {

        return dishService.insertDish (dish);

    }

    @ApiOperation("查询菜品分页查询")
    @GetMapping("/searchDishs")
    public Page<Dish> searchDishs (@RequestBody Dish dish) {

        return dishService.searchDishs (dish);

    }

    @ApiOperation("批量删除菜品")
    @DeleteMapping("/deleteDishs")
    public String delete (Long[] ids) {

        return dishService.deleteDishs (ids);
    }

    @ApiOperation("批量更新菜品状态")
    @PostMapping("/updateDishsStatus")
    public String updateDishsStatus (@RequestParam("ids") Long[] ids,@RequestParam("status") String status) {

       return dishService.updateDishsStatus (ids,status);
    }

    @ApiOperation ("更新菜品信息")
    @PutMapping("/updateDish")
    public String updateDish(Dish dish) {

        return dishService.updateDish (dish);
    }



}
