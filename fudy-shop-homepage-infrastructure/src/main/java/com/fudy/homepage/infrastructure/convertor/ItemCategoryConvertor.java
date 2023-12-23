package com.fudy.homepage.infrastructure.convertor;

import com.fudy.homepage.domain.model.item.ItemCategory;
import com.fudy.homepage.infrastructure.data.ItemCategoryDO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = EntityConvertor.class)
public interface ItemCategoryConvertor {

    @Mapping(source = "categoryId", target = "id")
    ItemCategory toItemCategory(ItemCategoryDO itemCategoryDO);
}
