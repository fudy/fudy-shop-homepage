package com.fudy.homepage.domain.repository;

import com.fudy.homepage.domain.model.item.ItemCategoryLine;

import java.util.List;

public interface ItemCategoryRepository {
    List<ItemCategoryLine> getData();
}
