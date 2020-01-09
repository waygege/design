package com.ecut.design.Repository;

import com.ecut.design.Model.Coupons;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface CouponsRepository extends JpaRepository<Coupons,Long> {

    @Modifying
    @Transactional
    @Query(value = "delete from coupons where id in (:ids)",nativeQuery = true)
    void deleteByIds(Long[] ids);
}
