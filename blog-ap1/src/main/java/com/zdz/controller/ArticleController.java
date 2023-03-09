package com.zdz.controller;

import com.zdz.dao.pojo.Article;
import com.zdz.service.ArticleService;
import com.zdz.vo.ArticleVo;
import com.zdz.vo.Result;
import com.zdz.vo.params.PageParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
