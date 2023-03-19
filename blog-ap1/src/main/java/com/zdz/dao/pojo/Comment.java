package com.zdz.dao.pojo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

@Data
public class Comment {

    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;

    private String Content;

    private Long CreateDate;

    private Long ArticleId;

    private Long AuthorId;

    private Long ParentId;

    private Long toUid;

    private Integer level;

}
