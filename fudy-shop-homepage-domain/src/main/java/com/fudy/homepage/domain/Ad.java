package com.fudy.homepage.domain;

import lombok.Data;

@Data
public class Ad {
    /**
     * 广告的商品详情链接
     */
    private String url;
    /**
     * 图片的提示文案
     */
    private String text;
    /**
     * 图片的宽度
     */
    private String width;
    /**
     * 图片的高度
     */
    private String height;
    /**
     * mock的时候使用的背景颜色
     */
    private String bgColor;
}
