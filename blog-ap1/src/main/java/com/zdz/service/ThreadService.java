package com.zdz.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.zdz.dao.mapper.ArticleMapper;
import com.zdz.dao.pojo.Article;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class ThreadService {

    //希望此操作在线程池中执行 ，这样就不会影响原有的主线程了
    @Async("taskExecutor")
    public void updateArticleViewCount(ArticleMapper articleMapper , Article article){
        int viewCount = article.getViewCounts();
        Article articleUpdater = new Article();
        articleUpdater.setViewCounts(viewCount+1);
        LambdaUpdateWrapper<Article> updateArticle = new LambdaUpdateWrapper<>();
        updateArticle.eq(Article::getId,article.getId());
        //为了在多线程的环境下实现线程安全，
        //y要设置一个
        updateArticle.eq(Article::getViewCounts,article.getViewCounts());
        //sql:update article set view_count = ? where view_count=99 and id = ? ;
        articleMapper.update(articleUpdater,updateArticle);
        try {
            Thread.sleep(5000);
            System.out.println("更新完成");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
