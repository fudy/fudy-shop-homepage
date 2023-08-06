package com.fudy.homepage.application;

import com.fudy.homepage.application.assembler.ItemCategoryLineAssembler;
import com.fudy.homepage.interfaces.dto.ItemCategoryLineDTO;
import com.fudy.homepage.infrastructure.nacos.ItemCategoryConfig;
import com.fudy.homepage.interfaces.manager.ItemCategoryManagerInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemCategoryManager implements ItemCategoryManagerInterface {
    @Autowired
    private ItemCategoryConfig config;
    @Autowired
    private ItemCategoryLineAssembler assembler;

    public List<ItemCategoryLineDTO> getItemCategoryList() {
        return assembler.toItemCategoryLineDTOList(config.getData());
    }
}
