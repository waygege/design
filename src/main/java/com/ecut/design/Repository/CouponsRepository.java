package com.ecut.design.Repository;

import com.ecut.design.Model.Coupons;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CouponsRepository extends JpaRepository<Coupons,Long> {

    @Query(value = "delete from coupons where id in(:ids)",nativeQuery = true)
    public  void deleteByIds(Long[] ids);
}
