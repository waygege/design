package com.ecut.design.Repository;

import com.ecut.design.Model.Evaluate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface EvaluateRepository extends JpaRepository<Evaluate,Long> , JpaSpecificationExecutor<Evaluate> {

    @Query(value = "select u.*,r.*,e.* from user_t u,restaurant r,evaluate e " +
            "where u.id=e.user_id and r.id =e.restaurant_id and u.username like  %:userName% and  r.name like %:restaurantName% ",nativeQuery = true)
    public List<Evaluate> findEvaluates1(String userName, String restaurantName, Pageable pageable );

    @Query(value = "select u.*,r.*,e.* from user_t u,restaurant r,evaluate e where u.id=e.user_id and r.id =e.restaurant_id and u.username like  %:userName% and  r.name like %:restaurantName%  and e.comment_time " +
            "between :commentStartTime and :commentEndTime",nativeQuery = true)
    public List<Evaluate> findEvaluates2(String userName, String restaurantName, LocalDateTime commentStartTime, LocalDateTime commentEndTime, Pageable pageable );



}
