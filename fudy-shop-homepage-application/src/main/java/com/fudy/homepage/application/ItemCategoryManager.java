package com.fudy.homepage.application;

import com.fudy.homepage.application.assembler.ItemCategoryLineAssembler;
import com.fudy.homepage.application.dto.ItemCategoryLineDTO;
import com.fudy.homepage.domain.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemCategoryManager  {
    @Autowired
    private ItemService itemService;
    @Autowired
    private ItemCategoryLineAssembler assembler;

    public List<ItemCategoryLineDTO> getItemCategoryList() {
        return assembler.toItemCategoryLineDTOList(itemService.getItemCategoryLineList());
    }
}
