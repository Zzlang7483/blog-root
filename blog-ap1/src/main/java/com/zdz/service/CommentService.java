package com.zdz.service;

import com.zdz.vo.Result;
import com.zdz.vo.params.CommentParam;

public interface CommentService {

    Result commentByArticleId(Long articleId);

    Result comment(CommentParam commentParam);
}
