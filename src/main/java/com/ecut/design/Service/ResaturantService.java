package com.ecut.design.Service;

import com.ecut.design.Model.Restaurant;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ResaturantService {

    @ApiOperation ("添加餐厅")
    public String insertRestaurant(Restaurant restaurant);


    @ApiOperation ("删除餐厅")
    public String deleteRestaut(Long id);

    @ApiOperation ("查询餐厅")
    public Page<Restaurant> searchRestaurants(Restaurant restaurant);

    @ApiOperation ("更新餐厅信息")
    public String updateRestaurant(Restaurant restaurant);

}
