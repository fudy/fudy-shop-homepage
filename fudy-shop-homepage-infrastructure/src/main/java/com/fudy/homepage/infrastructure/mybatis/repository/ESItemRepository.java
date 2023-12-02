package com.fudy.homepage.infrastructure.mybatis.repository;

import com.fudy.homepage.domain.repository.ItemRepository;
import com.fudy.homepage.domain.item.Item;
import com.fudy.homepage.infrastructure.elasticsearch.ESPagingQuery;
import com.fudy.homepage.infrastructure.elasticsearch.ElasticSearchFacade;
import com.fudy.homepage.infrastructure.elasticsearch.IndexCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Repository("ESItemRepository")
public class ESItemRepository implements ItemRepository {
    public static final String ID = "id";
    public static final String ITEM = "item";
    @Autowired
    private ElasticSearchFacade facade;

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
    public List<Item> search(String keyword) throws Exception {
        return facade.search(ITEM, "name", keyword, Item.class);
    }
}
