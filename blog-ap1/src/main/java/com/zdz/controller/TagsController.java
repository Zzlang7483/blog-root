package com.zdz.controller;

import com.zdz.dao.pojo.Tag;
import com.zdz.service.TagService;
import com.zdz.vo.Result;
import com.zdz.vo.TagVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("tags")
public class TagsController {

    @Autowired
    private TagService tagService;

    @GetMapping("/hot")
    public Result listHotTags() {
//        int i = 10/0;
        int limit = 4;
        List<TagVo> tagVoList = tagService.hot(limit);
        return Result.success(tagVoList);
    }

    @GetMapping
    public Result findAll(){
        return tagService.findAll();
    }
}
