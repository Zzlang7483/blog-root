package com.zdz.vo;

import lombok.Data;

/**
 * VO是和页面交互的对象，他不能和数据库的POJO耦合，所以要分开
 */
@Data
public class TagVo {

    private Long id;



    private String tagName;


}
