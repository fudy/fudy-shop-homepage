package com.fudy.homepage.application.repository;

import com.fudy.homepage.domain.Item;
import com.fudy.homepage.application.dto.PaginationQuery;

import java.util.List;

public interface ItemRepository {
    List<Item> getItemList(PaginationQuery query);

    void saveItemList(List<Item> itemList) throws Exception;

    void saveItem(Item item) throws Exception;
}
