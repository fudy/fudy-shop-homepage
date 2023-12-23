package com.fudy.homepage.domain.service;

import com.fudy.homepage.domain.model.item.Item;
import com.fudy.homepage.domain.model.item.ItemCategoryLine;
import com.fudy.homepage.domain.repository.ItemCategoryRepository;
import com.fudy.homepage.domain.repository.ItemRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class ItemService {
    private ItemRepository esRepository;
    private ItemRepository dbRepository;
    private ItemCategoryRepository categoryRepository;

    @Autowired
    public ItemService(@Qualifier("ESItemRepository") ItemRepository esRepository,
                       @Qualifier("DBItemRepository") ItemRepository dbRepository,
                       ItemCategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
        this.esRepository = esRepository;
        this.dbRepository = dbRepository;
    }

    public List<Item> getItemListFromES(Integer pageIndex, Integer pageSize ) {
        return esRepository.getItemList(pageIndex, pageSize);
    }

    public List<Item> getItemListFromDB(Integer pageIndex, Integer pageSize ) {
        return dbRepository.getItemList(pageIndex, pageSize);
    }


    public List<ItemCategoryLine> getItemCategoryLineList() {
        return categoryRepository.getData();
    }

    public void saveItemListToES(List<Item> itemList) throws Exception {
        esRepository.saveItemList(itemList);
    }

    public void syncItemFromDB2ES() {
        log.warn("start item sync");
        List<Item> itemList = null;
        int pageIndex = 0, pageSize = 100;
        try {
            do {
                //从DB读取数据
                itemList = this.getItemListFromDB(pageIndex, pageSize);
                //将数据插入到搜索引擎ES中
                this.saveItemListToES(itemList);
                //下一页
                pageIndex += pageSize;
            } while (itemList.size() == pageSize); //拿出一整页的数据，可能还有数据
        } catch (Exception e) {
            log.error("error", e);
        }
        log.warn("finish item sync");
    }

    public List<Item> search(String keyword) throws Exception {
        return esRepository.search(keyword);
    }
}
