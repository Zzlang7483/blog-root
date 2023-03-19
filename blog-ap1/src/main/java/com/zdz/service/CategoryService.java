package com.zdz.service;

import com.zdz.vo.CategoryVo;
import com.zdz.vo.Result;

public interface CategoryService {

    CategoryVo findCategoryById(Long id);

    Result findAll();
}
