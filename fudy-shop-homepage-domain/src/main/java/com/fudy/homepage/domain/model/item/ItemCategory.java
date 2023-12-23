package com.fudy.homepage.domain.model.item;

import com.fudy.homepage.domain.model.Entity;
import com.fudy.homepage.domain.model.ID;
import lombok.Data;

@Data
public class ItemCategory implements Entity<ID> {
    /**
     * 类目id
     */
    private ID id;
    /**
     * 类目名称
     */
    private String name;
    /**
     * 类目url
     */
    private String url;

}
