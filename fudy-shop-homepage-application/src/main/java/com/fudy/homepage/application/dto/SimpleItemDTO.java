package com.fudy.homepage.application.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class SimpleItemDTO implements Serializable {
    private static final long serialVersionUID = -1752495821105167936L;
    /**
     * 商品名称
     */
    private String name;
    /**
     * 商品主图
     */
    private String image;
    /**
     * 展示的价格
     */
    private String price;
}
