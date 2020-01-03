package com.ecut.design.Service;

import com.ecut.design.Model.Category;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;

import java.util.List;

public interface CategoryService {
    @ApiOperation ("添加分类")
    public String insertCategory(Category category);

    @ApiOperation ("删除分类")
    public String deleteCategory(Long id);

    @ApiOperation ("更新分类")
    public String updateCategory(Category category);

    @ApiOperation ("查找分类")
    public Page<Category> findCategoriesByCategoryId(Category category);
}
