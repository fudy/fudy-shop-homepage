package com.fudy.homepage.application.repository;

import com.fudy.homepage.domain.Item;
import com.fudy.homepage.interfaces.dto.PaginationQuery;

import java.util.List;

public interface ItemRepository {
    List<Item> getItemList(PaginationQuery query);
}
