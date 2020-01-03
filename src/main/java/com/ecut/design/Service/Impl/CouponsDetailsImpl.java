package com.ecut.design.Service.Impl;


import com.ecut.design.Config.util.UUIDUtils;
import com.ecut.design.Model.Coupons;
import com.ecut.design.Model.CouponsDetails;
import com.ecut.design.Model.User;
import com.ecut.design.Repository.CouponsDetailsRepository;
import com.ecut.design.Repository.CouponsRepository;
import com.ecut.design.Service.CouponsDetailsService;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class CouponsDetailsImpl implements CouponsDetailsService {

    @Autowired
    CouponsDetailsRepository couponsdetailsRepository;
    @Autowired
    CouponsRepository couponsRepository;

    @Autowired
    UUIDUtils uuidUtils;



    @ApiOperation("发放给用户优惠卷")
    @Override
    public String sendCouponsDetails(Long couponsId,Long[] userIds){
       List <CouponsDetails> couponsDetailsList=couponsdetailsRepository.findCouponsDetailsByCouponsId (couponsId);
       for (int i=0;i<userIds.length;i++) {
           CouponsDetails couponsDetails=couponsDetailsList.get (i);
           couponsDetails.setCreateAt (LocalDateTime.now ());
           couponsDetails.setStatus (CouponsDetails.STATUS_ACTIVE);
           couponsDetails.setUserId (userIds[i]);
           couponsdetailsRepository.save (couponsDetails);
       }
        return "successs";
    }

    @ApiOperation ("核销当前登录优惠卷")
    @Override
    public String updateCouponsDetails(Long id ){
        CouponsDetails couponsDetails=couponsdetailsRepository.getOne (id);
         couponsDetails.setStatus (CouponsDetails.STATUS_USED);
         couponsDetails.setUsedAt (LocalDateTime.now ());
        couponsdetailsRepository.save (couponsDetails);
        return "success";
    }

    @ApiOperation ("查看当前登录用户优惠卷")
    @Override
    public List<CouponsDetails> findAllCouponsDetails(){
        Long currentUserId =( (User) SecurityUtils.getSubject().getSession().getAttribute("user")).getId ();
      List<CouponsDetails> couponsDetailsList=couponsdetailsRepository.findAllCouponsDetailsByUserId(currentUserId);
      for(CouponsDetails couponsDetails:couponsDetailsList)
      {
          couponsDetails=isValidCoupons (couponsDetails);
      }
        return  couponsDetailsList;
    }



    @ApiOperation ("判断优惠卷是否过期")
    public  CouponsDetails isValidCoupons(CouponsDetails couponsDetails){
    Coupons coupons= couponsRepository.getOne (couponsDetails.getCouponsId ());
        if (LocalDateTime.now ().isAfter (coupons.getEndTime ())){
            couponsDetails.setStatus (CouponsDetails.STATUS_EXPIRED);
        }
        couponsdetailsRepository.save (couponsDetails);
        return couponsDetails;
    }

}
