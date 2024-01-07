package com.fudy.homepage.domain.repository;

import com.fudy.homepage.domain.model.ID;
import com.fudy.homepage.domain.model.item.Item;
import com.fudy.homepage.domain.model.search.Keyword;
import com.fudy.homepage.domain.model.search.SortField;
import com.fudy.homepage.domain.model.search.SortOrder;

import java.util.List;

public interface ItemRepository {
    List<Item> getItemList(Integer pageIndex,Integer pageSize );

    void saveItemList(List<Item> itemList) throws Exception;

    void saveItem(Item item) throws Exception;

    default List<Item> search(Keyword keyword, SortField sortField, SortOrder sortOrder) throws Exception {
        return null;
    }

    List<Item> searchByCategoryId(ID categoryId, SortField sortField, SortOrder sortOrder) throws Exception;
}
