package com.zdz.service;

import com.zdz.vo.ArticleVo;
import com.zdz.vo.Result;
import com.zdz.vo.params.PageParams;

import java.util.List;

public interface ArticleService {
    /**
     * 分页查询文章列表
     * @param
     * @return
     */
    List<ArticleVo> listArticlesPage(PageParams pageParams);
}
