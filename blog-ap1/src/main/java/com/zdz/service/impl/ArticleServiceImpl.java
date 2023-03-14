package com.zdz.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zdz.dao.dos.Archives;
import com.zdz.dao.mapper.ArticleMapper;
import com.zdz.dao.mapper.TagMapper;
import com.zdz.dao.pojo.Article;
import com.zdz.dao.pojo.SysUser;
import com.zdz.service.ArticleService;
import com.zdz.service.SysUserService;
import com.zdz.service.TagService;
import com.zdz.vo.ArticleVo;
import com.zdz.vo.Result;
import com.zdz.vo.TagVo;
import com.zdz.vo.params.PageParams;
import org.joda.time.DateTime;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import static com.alibaba.fastjson.JSONPatch.OperationType.copy;
import static net.sf.jsqlparser.parser.feature.Feature.limit;

@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleMapper articleMapper;
    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private TagService tagsService;

    public ArticleVo copy(Article article,boolean isAuthor,boolean isBody,boolean isTags){
        ArticleVo articleVo = new ArticleVo();
        BeanUtils.copyProperties(article, articleVo);
        if (isAuthor) {
            SysUser sysUser = sysUserService.findUserById(article.getAuthorId());
            articleVo.setAuthor(sysUser.getNickname());
        }
        articleVo.setCreateDate(new DateTime(article.getCreateDate()).toString("yyyy-MM-dd HH:mm"));
        if (isTags){
            List<TagVo> tags = tagsService.findTagsByArticleId(article.getId());
            articleVo.setTags(tags);
        }
        return articleVo;
    }

    private List<ArticleVo> copyList(List<Article> records,boolean isAuthor,boolean isBody,boolean isTags) {
        List<ArticleVo> articleVoList = new ArrayList<>();
        for (Article article : records) {
            ArticleVo articleVo = copy(article,isAuthor,isBody,isTags);
            articleVoList.add(articleVo);
        }
        return articleVoList;
    }


    @Override
    public List<ArticleVo> listArticlesPage(PageParams pageParams) {
        Page<Article> page = new Page<>(pageParams.getPage(), pageParams.getPageSize());
        LambdaQueryWrapper<Article> queryWrapper = new LambdaQueryWrapper<>();
//        queryWrapper.eq(Article::getIsDelete,0);
        //是否置顶进行排序
        queryWrapper.orderByDesc(Article::getCreateDate);
        Page<Article> articlePage = articleMapper.selectPage(page,queryWrapper);

        List<Article> records = articlePage.getRecords();
        List<ArticleVo> articleVoList = copyList(records,true,true,true);
        return articleVoList;

    }

    @Override
    public Result hotArticle(int limit) {
        LambdaQueryWrapper<Article> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.orderByDesc(Article::getViewCounts);
        queryWrapper.select(Article::getId,Article::getTitle);
        queryWrapper.last("limit "+limit);
        //select id ,title from article order by view_counts desc limit 5
        List<Article> articles = articleMapper.selectList(queryWrapper);
        return Result.success(copyList(articles,false,false,false));
    }

    @Override
    public Result newArticle(int limit) {
        LambdaQueryWrapper<Article> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.orderByDesc(Article::getCreateDate);
        queryWrapper.select(Article::getId,Article::getTitle);
        queryWrapper.last("limit "+limit);
        //select id ,title from article order by create_date desc limit
        List<Article> articles = articleMapper.selectList(queryWrapper);
        return Result.success(copyList(articles,false,false,false));

    }

    @Override
    public Result listArchives() {
        List<Archives> archives =  articleMapper.listArchives();
        return Result.success(archives);
    }
}
