package com.ecut.design.Repository;

import com.ecut.design.Model.Category;
import com.ecut.design.Model.Restaurant;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {

    @Query(value = "select * from category where category_id=?1",nativeQuery = true)
    Page<Category> findCategoriesByCategoryId(Long categoryId, Pageable pageable);

    @Query(value = "select * from category where category_id=?1",nativeQuery = true)
    List<Category> findCategoriesListByCategoryId(Long categoryId);


}
