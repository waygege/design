package com.ecut.design.Service.Impl;

import com.ecut.design.Config.util.PageableUtils.PageableUtil;

import com.ecut.design.Config.util.IdProduct.UUIDUtils;
import com.ecut.design.Model.Coupons;
import com.ecut.design.Model.CouponsDetails;
import com.ecut.design.Repository.CouponsDetailsRepository;
import com.ecut.design.Repository.CouponsRepository;
import com.ecut.design.Service.CouponsService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CouponsImpl implements CouponsService {

    @Autowired
    CouponsRepository couponsRepository;
    @Autowired
    PageableUtil pageableUtil;
    @Autowired
    CouponsDetailsRepository couponsdetailsRepository;

    @Autowired
    UUIDUtils uuidUtils;



    @ApiOperation ("添加优惠卷")
    @Override
    public String insertCoupons(Coupons coupons){
        coupons=couponsIsEnable (coupons);
        couponsRepository.save (coupons);
        return "success";
    }

    @ApiOperation ("更新优惠卷")
    @Override
    public String updateCoupons(Coupons coupons){
        coupons=couponsIsEnable (coupons);
        couponsRepository.save (coupons);
        return "success";
    }

    @ApiOperation ("删除优惠卷")
    @Override
    public String deleteCoupons(Long[] ids){
      couponsRepository.deleteByIds (ids);
        return "success";
    }

    @ApiOperation ("查询优惠卷")
    @Override
    public Page<Coupons> findeCoupons(Coupons coupons){
        ExampleMatcher matcher=ExampleMatcher.matching ()
                .withMatcher ("activityName",ExampleMatcher.GenericPropertyMatchers.contains())
                .withIgnorePaths ("id")
                .withIgnorePaths ("activityTypeId");
        Example<Coupons> activityExample=Example.of (coupons,matcher);
        Pageable pageable=pageableUtil.getPageable (coupons.getPageExample ());
        Page<Coupons> page=couponsRepository.findAll (activityExample,pageable);
        List<Coupons> couponsList =page.getContent ();
        for (Coupons couponsupdate:couponsList){
          couponsupdate=couponsIsEnable (couponsupdate);
        }
        Page<Coupons> pageAfter=new PageImpl (couponsList,new PageableUtil ().getPageable (coupons.getPageExample ()),couponsList.size ());
        return  pageAfter;
    }


    @ApiOperation ("优惠卷的上下架")
    @Override
    public String upOrDownCoupons(Long id ,String status){
        Coupons coupons=couponsIsUp (id,status);
        couponsRepository.save (coupons);
      return "success";
    }

    @ApiOperation ("发放优惠卷")
    @Override
    public String sendCouponsDetails(Coupons coupons){
        for (int i=0;i<coupons.getIssueTotal ();i++) {
            CouponsDetails couponsDetails=new CouponsDetails ();
            couponsDetails.setCouponsId (coupons.getId ());
            String cdKey = uuidUtils.getUUID ();
            couponsDetails.setCdKey (cdKey);
            couponsDetails.setStatus (CouponsDetails.STATUS_UNRECEIVED);
            couponsdetailsRepository.save (couponsDetails);
        }
        return "success";
    }





    @ApiOperation ("判断优惠卷的状态")
    public  Coupons couponsIsEnable(Coupons coupons){
        if ((LocalDateTime.now ().isBefore (coupons.getStartTime ())
                ||(LocalDateTime.now ().isAfter (coupons.getStartTime ())
                &&LocalDateTime.now ().isBefore (coupons.getEndTime ())))
                &&coupons.getStatus ().equals (""))
        {
            coupons.setStatus (Coupons.STATUS_SATRT);
        }else if(LocalDateTime.now ().isAfter (coupons.getEndTime ())){

         coupons.setStatus (Coupons.STATUS_TIMEOUT);
        }

        return coupons;
    }


    @ApiOperation ("判断是否能上架")
    public Coupons couponsIsUp(Long id,String status){
        Coupons coupons=couponsRepository.getOne (id);
        if (!LocalDateTime.now().isAfter (coupons.getEndTime ())&&status.equals (Coupons.STATUS_ONSHOW)){
          coupons.setStatus (status);
        }else {
                coupons.setStatus (status);
        }
        return coupons;
    }



}
