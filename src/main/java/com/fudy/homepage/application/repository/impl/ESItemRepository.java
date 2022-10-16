package com.fudy.homepage.application.repository.impl;

import com.fudy.homepage.application.repository.ItemRepository;
import com.fudy.homepage.domain.Item;
import com.fudy.homepage.infrastructure.elasticsearch.ESPagingQuery;
import com.fudy.homepage.infrastructure.elasticsearch.ElasticSearchFacade;
import com.fudy.homepage.interfaces.dto.PaginationQuery;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Slf4j
@Repository("ESItemRepository")
public class ESItemRepository implements ItemRepository {
    public static final String ID = "id";
    public static final String ITEM = "item";
    @Autowired
    private ElasticSearchFacade facade;

    @Override
    public List<Item> getItemList(PaginationQuery query) {
        ESPagingQuery q =  ESPagingQuery.builder()
                .index(ITEM)
                .from(query.getPageIndex())
                .size(query.getPageSize())
                .sortField(ID)
                .build();
        try {
            return facade.pagingSearch(q, Item.class);
        } catch (Exception e) {
            log.error(e.getMessage());
            return null;
        }
    }
}
