package com.ecut.design.Service.Impl;

import com.ecut.design.Config.util.PageableUtils.PageableUtil;
import com.ecut.design.Model.Article;
import com.ecut.design.Model.PageExample;
import com.ecut.design.Repository.ArticleRepository;
import com.ecut.design.Service.ArticleService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class ArticleImpl implements ArticleService {

    @Autowired
    ArticleRepository articleRepository;
    @Autowired
    PageableUtil pageableUtil;

    @ApiOperation ("添加文章")
    @Override
    public String insertArticle(Article article){
        articleRepository.save (article);
        return "success";
    }


    @ApiOperation ("更新文章")
    public String updateArticle(Article article){
        articleRepository.save (article);
        return "success";
    }


    @ApiOperation ("删除文章")
    @Override
    public String deleteArticle(Long id) {
        articleRepository.deleteById (id);
        return "success";
    }

    @ApiOperation ("查询文章")
    @Override
    public Page<Article> findAllArticles(Article article){
        PageExample pageExample= article.getPageExample ();
        Pageable pageable = pageableUtil.getPageable (pageExample);
        return    articleRepository.findAll (pageable);

    }

    @ApiOperation ("查看文章内容")
    @Override
    public Article findArticleById(Long id){

        return articleRepository.findById (id).get ();
    }
}
