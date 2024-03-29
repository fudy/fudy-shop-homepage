package com.fudy.homepage.application.assembler;

import com.fudy.homepage.application.dto.ItemCategoryDTO;
import com.fudy.homepage.application.dto.ItemCategoryLineDTO;
import com.fudy.homepage.domain.model.item.ItemCategory;
import com.fudy.homepage.domain.model.item.ItemCategoryLine;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ItemCategoryLineAssembler {
    ItemCategoryLineDTO toItemCategoryLineDTO(ItemCategoryLine line);
    List<ItemCategoryLineDTO> toItemCategoryLineDTOList(List<ItemCategoryLine> list);

    @Mapping(source = "id.value", target = "categoryId")
    ItemCategoryDTO toItemCategoryDTO(ItemCategory itemCategory);
    List<ItemCategoryDTO> toItemCategoryDTOList(List<ItemCategory> list);
}
