package com.fudy.homepage.domain.repository;

import com.fudy.homepage.domain.item.Item;

import java.util.List;

public interface ItemRepository {
    List<Item> getItemList(Integer pageIndex,Integer pageSize );

    void saveItemList(List<Item> itemList) throws Exception;

    void saveItem(Item item) throws Exception;
}
