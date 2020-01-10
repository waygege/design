package com.ecut.design.Service.Impl;

import com.ecut.design.Config.util.PageableUtils.PageableUtil;
import com.ecut.design.Model.Category;
import com.ecut.design.Repository.CategoryRepository;
import com.ecut.design.Service.CategoryService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CategoryImpl implements CategoryService {
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    PageableUtil pageableUtil;

    @ApiOperation ("添加分类")
    @Override
    public String insertCategory (Category category) {
       categoryRepository.save (category);
        return "success";
    }

    @ApiOperation ("删除分类")
    @Override
    public String deleteCategory (Long id) {
      Category category=categoryRepository.getOne (id);
      if(category.getCategoryId ()!=0){
         categoryRepository.deleteById (id);
         return "success";
      }else {
        if (categoryRepository.findCategoriesListByCategoryId(id).size ()==0){
            categoryRepository.deleteById (id);
            return "success";
        }
      }//该分类的子类没删干净
        return "error";
    }

    @ApiOperation ("更新分类")
    @Override
    public String updateCategory (Category category) {
     categoryRepository.save (category);
        return "success";
    }

    @ApiOperation ("查找分类")
    @Override
    public Page<Category> findCategoriesByCategoryId (Category category) {

        Pageable pageable= pageableUtil.getPageable (category.getPageExample ());
        return   categoryRepository.findCategoriesByCategoryId (category.getId (),pageable);

    }


}
