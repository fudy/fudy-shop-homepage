package com.fudy.homepage.application.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class ItemCategoryDTO implements Serializable {
    private static final long serialVersionUID = 8233429155952872973L;
    /**
     * 类目ID
     */
    private Long categoryId;
    /**
     * 类目名称
     */
    private String name;
    /**
     * 类目url
     */
    private String url;
}
