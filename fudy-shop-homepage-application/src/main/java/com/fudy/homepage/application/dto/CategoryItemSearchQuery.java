package com.fudy.homepage.application.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class CategoryItemSearchQuery {
    /** 类目ID */
    @NotNull(message = "查询类目不能为空")
    private Long categoryId;
}
