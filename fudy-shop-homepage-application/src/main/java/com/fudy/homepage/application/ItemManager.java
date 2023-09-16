package com.fudy.homepage.application;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.fudy.homepage.application.assembler.SimpleItemAssembler;
import com.fudy.homepage.application.dto.SimpleItemDTO;
import com.fudy.homepage.domain.item.ItemService;
import com.fudy.homepage.domain.item.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Validated
@Service
public class ItemManager {
    @Autowired
    private ItemService service;
    @Autowired
    private SimpleItemAssembler assembler;

    @SentinelResource(value = "getItemList")
    public List<SimpleItemDTO> getItemList(Integer pageIndex, Integer pageSize ) {
        List<Item> itemList = service.getItemListFromES(pageIndex, pageSize);
        return assembler.toSimpleItemDTOList(itemList);
    }
}
