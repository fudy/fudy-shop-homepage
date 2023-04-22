package com.fudy.homepage.interfaces.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class ItemCategoryLineDTO implements Serializable {
    private static final long serialVersionUID = -4057785716191394276L;
    private List<ItemCategoryDTO> itemCategoryList;
}
