package com.ecut.design.Controller;

import com.ecut.design.Model.Article;
import com.ecut.design.Service.ArticleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/article")
@Api(tags = "文章管理模块",value="文章管理模块")
public class ArticleController {

    @Autowired
    ArticleService articleService;

    @ApiOperation("添加文章")
    @PostMapping("/insertArticle")
    public String insertArticle(@RequestBody Article article){

        return articleService.insertArticle (article);
    }


    @ApiOperation ("更新文章")
    @PutMapping("/updateArticle")
    public String updateArticle(@RequestBody Article article){

        return articleService.updateArticle (article);
    }


    @ApiOperation ("删除文章")
    @DeleteMapping("/deleteArticle")
    public String deleteArticle(Long id) {

        return articleService.deleteArticle (id);
    }


    @ApiOperation ("查询文章")
    @GetMapping("/findAllArticles")
    public Page<Article> findAllArticles(@RequestBody Article article){

        return  articleService.findAllArticles (article);
    }
}
