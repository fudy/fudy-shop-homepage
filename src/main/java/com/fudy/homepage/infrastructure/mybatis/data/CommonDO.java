package com.fudy.homepage.infrastructure.mybatis.data;

import lombok.Data;

import java.util.Date;

@Data
public class CommonDO {
    /**
     * 表id
     */
    private Long id;
    /**
     * 创建时间
     */
    private Date createdTime;
    /**
     * 更新时间
     */
    private Date modifiedTime;
}
