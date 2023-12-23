package com.fudy.homepage.infrastructure.convertor;

import com.fudy.homepage.domain.model.item.ItemCategoryLine;
import com.fudy.homepage.infrastructure.data.ItemCategoryLineDO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = ItemCategoryConvertor.class)
public interface ItemCategoryLineConvertor {

    ItemCategoryLine toItemCategoryLine(ItemCategoryLineDO itemCategoryLineDO);

    List<ItemCategoryLine> toItemCategoryLine(List<ItemCategoryLineDO> itemCategoryLineDOs);
}
