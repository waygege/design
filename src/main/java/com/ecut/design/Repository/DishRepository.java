package com.ecut.design.Repository;

import com.ecut.design.Model.Dish;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface DishRepository extends JpaRepository<Dish,Long> {

    @Modifying
    @Transactional
    @Query(value="delete from dish  where id in (:ids)",nativeQuery = true)
    void deleteByDishIds(Long[] ids);

    @Modifying
    @Transactional
    @Query(value="update dish set status=:status where id in (:ids)",nativeQuery = true)
    public void updateDishsStatus(Long[] ids, String status);



    @Query(value="select * from dish where id in (:ids)",nativeQuery = true)
    public List<Dish> findDishsByIds(Long[] ids);

}
