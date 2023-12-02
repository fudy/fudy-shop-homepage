package com.fudy.homepage.application.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class ItemSearchQuery {
    /** 查询关键词 */
    @NotNull(message = "查询关键字不能为空")
    private String keyword;
}
