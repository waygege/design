package com.ecut.design.Repository;

import com.ecut.design.Model.Options;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface OptionRepository extends JpaRepository<Options,Long> {


    @Modifying
    @Transactional
    @Query(value = "delete from `options` where  activity_id=:id",nativeQuery = true)
    public void deleteByActivityId(Long id);


   @Query(value = "select * from  `options` o where o.activity_id=:activityId",nativeQuery = true)
    public List<Options> findByActivityId(Long activityId);

}
