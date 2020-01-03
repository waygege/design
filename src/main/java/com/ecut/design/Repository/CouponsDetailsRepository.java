package com.ecut.design.Repository;

import com.ecut.design.Model.CouponsDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CouponsDetailsRepository extends JpaRepository<CouponsDetails,Long> {

    @Query(value = "select * from coupons_details where  user_id=:userId",nativeQuery = true)
    List<CouponsDetails> findAllCouponsDetailsByUserId(Long userId);


    @Query(value = "select * from coupons_details where coupons_id=:couponsId and user_id is null ",nativeQuery = true)
    List<CouponsDetails> findCouponsDetailsByCouponsId(Long couponsId);
}
