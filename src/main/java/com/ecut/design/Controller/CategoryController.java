package com.ecut.design.Controller;

import com.ecut.design.Model.Category;
import com.ecut.design.Service.CategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(value = "分类模块",tags = "分类模块")
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @ApiOperation ("添加分类")
    @PostMapping("/insertCategory")
    public String insertCategory(@RequestBody Category category){

        return categoryService.insertCategory (category);
    }
    @ApiOperation ("删除分类")
    @DeleteMapping("/deleteCategory")
    public String deleteCategory(Long id){

        return categoryService.deleteCategory (id);
    }

    @ApiOperation ("更新分类")
    @PutMapping("/updateCategory")
    public String updateCategory(@RequestBody Category category){

        return categoryService.updateCategory (category);
    }

    @ApiOperation ("查找分类")
    @GetMapping("/findCategorys")
    public Page<Category>  findCategoriesByCategoryId(@RequestBody Category category){

        return categoryService.findCategoriesByCategoryId (category);
    }
}
