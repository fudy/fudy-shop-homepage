package com.fudy.homepage.domain.item;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Item {
    /**
     * id
     */
    private Long id;
    /**
     * 商品id
     */
    private Long itemId;
    /**
     * 商品名称
     */
    private String name;
    /**
     * 类目id
     */
    private Long categoryId;
    /**
     * 商品描述
     */
    private String description;
    /**
     * 商品主图
     */
    private String image;
    /**
     * 商品其他图片
     */
    private String subImages;
    /**
     * 卖家id
     */
    private String sellerId;
    /**
     * 状态，如已发布，已下架，待发布等状态
     */
    private String status;
    /**
     * 价格
     */
    private BigDecimal price;
}
