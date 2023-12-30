package com.fudy.homepage.application;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.fudy.homepage.application.assembler.SimpleItemAssembler;
import com.fudy.homepage.application.dto.CategoryItemSearchQuery;
import com.fudy.homepage.application.dto.ItemSearchQuery;
import com.fudy.homepage.application.dto.SimpleItemDTO;
import com.fudy.homepage.domain.service.ItemService;
import com.fudy.homepage.domain.model.item.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
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

    public List<SimpleItemDTO> search(@Valid ItemSearchQuery query) throws Exception {
        List<Item> itemList = service.search(query.getKeyword());
        return assembler.toSimpleItemDTOList(itemList);
    }

    public List<SimpleItemDTO> searchItemsInCategory(CategoryItemSearchQuery query) throws Exception {
        List<Item> itemList = service.searchByCategoryId(query.getCategoryId());
        return assembler.toSimpleItemDTOList(itemList);
    }
}
