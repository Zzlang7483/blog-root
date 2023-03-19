package com.zdz.controller;

import com.zdz.common.aop.LogAnnotation;
import com.zdz.dao.pojo.Article;
import com.zdz.service.ArticleService;
import com.zdz.vo.ArticleVo;
import com.zdz.vo.Result;
import com.zdz.vo.params.ArticleParam;
import com.zdz.vo.params.PageParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//restController 都是json类型的数据交互
@RestController
@RequestMapping("articles")
public class ArticleController {

    @Autowired
    private ArticleService articleService;
    //Result是统一结果返回
    @PostMapping
    public Result articles(@RequestBody PageParams pageParams) {
        //ArticleVo 页面接收的数据
        List<ArticleVo> articles = articleService.listArticlesPage(pageParams);
        return Result.success(articles);
    }

    @PostMapping("/hot")
    public Result hotArticle() {
        int limit = 5;
        return articleService.hotArticle(limit);
    }

    @PostMapping("/new")
    public Result newArticle(){
        int limit = 2;
        return articleService.newArticle(limit);
    }

    @PostMapping("/listArchives")
    //加上此注解代表要对此接口记录日志
    @LogAnnotation(module = "文章" ,operation = "获取文章列表")
    public Result listArchives(){
        return articleService.listArchives();
    }

    @PostMapping("view/{id}")
    public Result findArticleById(@PathVariable("id") Long id){
        ArticleVo articleVo = articleService.findArticleById(id);
        return Result.success(articleVo);
    }
    @PostMapping("publish")
    public Result publish(@RequestBody ArticleParam articleParam){
        return articleService.publish(articleParam);
    }
}
