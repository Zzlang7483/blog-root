package com.zdz.service;

import com.zdz.dao.pojo.Tag;
import com.zdz.vo.TagVo;

import java.util.List;

public interface TagService {
    List<TagVo> findTagsByArticleId(Long Id);

     List<TagVo> hot(int limit);
}
