package com.ecut.design.Service;

import com.ecut.design.Model.Sign;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;

import java.util.List;

public interface SignService {

    @ApiOperation("活动报名")
    public String signActity(Sign sign);

    @ApiOperation ("查看报名详情")
    public Sign showSginDetail(Long id);

    @ApiOperation ("查看活动报名")
    public Page<Sign> findAllSigns(Sign sign);
}
