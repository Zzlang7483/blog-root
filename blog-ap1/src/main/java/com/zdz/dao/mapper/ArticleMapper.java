package com.zdz.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zdz.dao.dos.Archives;
import com.zdz.dao.pojo.Article;

import java.util.List;

public interface ArticleMapper extends BaseMapper<Article> {
    List<Archives> listArchives();
}
