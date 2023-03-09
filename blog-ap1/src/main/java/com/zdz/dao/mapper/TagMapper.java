package com.zdz.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zdz.dao.pojo.Tag;
import com.zdz.vo.TagVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

public interface TagMapper extends BaseMapper<Tag> {
    List<Tag> findTagsByArticleId(Long articleId);

}

