package com.ecut.design.Repository;

import com.ecut.design.Model.Banner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface BannerRepository extends JpaRepository<Banner,Long> {

    @Modifying
    @Transactional
    @Query(value = "delete from banner where id in (:ids)",nativeQuery = true)
    void deleteBannersByIds(@Param ("ids") Long[] ids);

    @Query(value = "select * from banner where status='展示中' ",nativeQuery = true)
    List<Banner> findShowBanners();
}
