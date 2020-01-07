package com.ecut.design.Service;

import com.ecut.design.Model.Article;
import com.ecut.design.Model.PageExample;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;

public interface ArticleService {

    @ApiOperation("添加文章")
    public String insertArticle(Article article);


    @ApiOperation ("更新文章")
    public String updateArticle(Article article);


    @ApiOperation ("删除文章")
    public String deleteArticle(Long id) ;

    @ApiOperation ("查询文章")
    public Page<Article> findAllArticles(Article article);

    @ApiOperation ("查看文章内容")
    public Article findArticleById(Long id);
}
