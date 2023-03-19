package com.zdz.controller;

import com.zdz.service.CategoryService;
import com.zdz.service.TagService;
import com.zdz.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("categorys")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;


    @GetMapping
    public Result listCategory(){
        return categoryService.findAll();
    }



}
