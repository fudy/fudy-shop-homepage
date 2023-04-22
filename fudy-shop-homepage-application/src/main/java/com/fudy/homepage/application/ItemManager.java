package com.fudy.homepage.application;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.fudy.homepage.application.assembler.SimpleItemAssembler;
import com.fudy.homepage.domain.repository.ItemRepository;
import com.fudy.homepage.domain.Item;
import com.fudy.homepage.interfaces.dto.SimpleItemDTO;
import com.fudy.homepage.interfaces.manager.ItemManagerInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Validated
@Service
public class ItemManager implements ItemManagerInterface {
    @Autowired @Qualifier("ESItemRepository")
    private ItemRepository repository;
    @Autowired
    private SimpleItemAssembler assembler;

    @SentinelResource(value = "getItemList")
    public List<SimpleItemDTO> getItemList(Integer pageIndex,Integer pageSize ) {
        List<Item> itemList = repository.getItemList(pageIndex, pageSize);
        return assembler.toSimpleItemDTOList(itemList);
    }
}
