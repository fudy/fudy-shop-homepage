package com.fudy.homepage.application;

import com.fudy.homepage.application.assembler.SimpleItemAssembler;
import com.fudy.homepage.application.repository.ItemRepository;
import com.fudy.homepage.domain.Item;
import com.fudy.homepage.interfaces.dto.PaginationQuery;
import com.fudy.homepage.interfaces.dto.SimpleItemDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.List;

@Validated
@Service
public class ItemManager {
    @Autowired
    private ItemRepository repository;
    @Autowired
    private SimpleItemAssembler assembler;

    public List<SimpleItemDTO> getItemList(@Valid PaginationQuery query) {
        List<Item> itemList = repository.getItemList(query);
        return assembler.toSimpleItemDTOList(itemList);
    }
}
