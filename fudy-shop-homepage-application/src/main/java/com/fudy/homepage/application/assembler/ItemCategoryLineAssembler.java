package com.fudy.homepage.application.assembler;

import com.fudy.homepage.domain.ItemCategory;
import com.fudy.homepage.domain.ItemCategoryLine;
import com.fudy.homepage.interfaces.dto.ItemCategoryDTO;
import com.fudy.homepage.interfaces.dto.ItemCategoryLineDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ItemCategoryLineAssembler {
    ItemCategoryLineDTO toItemCategoryLineDTO(ItemCategoryLine line);
    List<ItemCategoryLineDTO> toItemCategoryLineDTOList(List<ItemCategoryLine> list);

    ItemCategoryDTO toItemCategoryDTO(ItemCategory itemCategory);
    List<ItemCategoryDTO> toItemCategoryDTOList(List<ItemCategory> list);
}
