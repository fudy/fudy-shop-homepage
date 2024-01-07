package com.fudy.homepage.infrastructure.mybatis.repository;

import com.fudy.homepage.domain.model.ID;
import com.fudy.homepage.domain.model.search.Keyword;
import com.fudy.homepage.domain.model.search.SortField;
import com.fudy.homepage.domain.model.search.SortOrder;
import com.fudy.homepage.domain.repository.ItemRepository;
import com.fudy.homepage.domain.model.item.Item;
import com.fudy.homepage.infrastructure.convertor.SortOrderConvertor;
import com.fudy.homepage.infrastructure.elasticsearch.ESPagingQuery;
import com.fudy.homepage.infrastructure.elasticsearch.ElasticSearchFacade;
import com.fudy.homepage.infrastructure.elasticsearch.IndexCommand;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Repository("ESItemRepository")
public class ESItemRepository implements ItemRepository {
    public static final String ID = "id";
    public static final String ITEM = "item";
    @Autowired
    private ElasticSearchFacade facade;
    @Autowired
    private SortOrderConvertor sortOrderConvertor;

    @Override
    public List<Item> getItemList(Integer pageIndex,Integer pageSize ) {
        ESPagingQuery q =  ESPagingQuery.builder()
                .index(ITEM)
                .from(pageIndex)
                .size(pageSize)
                .sortField(ID)
                .build();
        try {
            return facade.pagingSearch(q, Item.class);
        } catch (Exception e) {
            log.error(e.getMessage());
            return null;
        }
    }

    private IndexCommand toIndexCommand(Item item) {
        IndexCommand cmd = new IndexCommand();
        cmd.setId(String.valueOf(item.getId()));
        cmd.setIndex(ITEM);
        cmd.setDoc(item);
        return cmd;
    }

    private List<IndexCommand> toIndexCommandList(List<Item> itemList) {
        List<IndexCommand> list = new ArrayList<>();
        for (Item item : itemList) {
            list.add(toIndexCommand(item));
        }
        return list;
    }

    @Override
    public void saveItemList(List<Item> itemList) throws Exception {
        facade.bulkIndex(toIndexCommandList(itemList));
    }

    @Override
    public void saveItem(Item item) throws Exception {
        facade.index(toIndexCommand(item));
    }

    @Override
    public List<Item> search(@NonNull Keyword keyword, SortField sortField, SortOrder sortOrder) throws Exception {
        String field = null == sortField ? null : sortField.getValue();
        co.elastic.clients.elasticsearch._types.SortOrder order = sortOrderConvertor.toSortOrder(sortOrder);
        return facade.search(ITEM, "name", keyword.getValue(), field, order, Item.class);
    }

    @Override
    public List<Item> searchByCategoryId(ID categoryId, SortField sortField, SortOrder sortOrder) throws Exception {
        String field = null == sortField ? null : sortField.getValue();
        co.elastic.clients.elasticsearch._types.SortOrder order = sortOrderConvertor.toSortOrder(sortOrder);
        return facade.search(ITEM,"categoryId", categoryId.toString(),field, order, Item.class);
    }
}
