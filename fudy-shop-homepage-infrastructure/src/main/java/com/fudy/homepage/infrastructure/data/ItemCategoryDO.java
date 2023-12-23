package com.fudy.homepage.infrastructure.data;

import lombok.Data;
import java.io.Serializable;

@Data
public class ItemCategoryDO implements Serializable {
    private static final long serialVersionUID = 841981017868104037L;
    /**
     * 类目id
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
