package com.fudy.homepage.interfaces.dto;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.io.Serializable;

@Data
public class PaginationQuery implements Serializable {
    private static final long serialVersionUID = 609098137265296364L;
    /**
     * 第几页，从0开始
     */
    @Min(0)
    private Integer pageIndex;
    /**
     * 每页的大小,一页最少10个，最多50个
     */
    @Min(10) @Max(50)
    private Integer pageSize;

    public PaginationQuery(Integer pageIndex, Integer pageSize) {
        this.pageIndex = pageIndex;
        this.pageSize = pageSize;
    }
}
