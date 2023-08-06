package com.fudy.homepage.application;

import com.fudy.homepage.domain.repository.ItemRepository;
import com.fudy.homepage.domain.Item;
import com.fudy.homepage.interfaces.manager.ItemSyncManagerInterface;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class ItemSyncManager implements ItemSyncManagerInterface {
    @Autowired
    @Qualifier("DBItemRepository")
    private ItemRepository dbRepository;

    @Autowired @Qualifier("ESItemRepository")
    private ItemRepository esRepository;

    public void execute() throws Exception {
        log.warn("start item sync");
        List<Item> itemList = null;
        int pageIndex = 0, pageSize = 100;
        try {
            do {
                //从DB读取数据
                itemList = dbRepository.getItemList(pageIndex, pageSize);
                //将数据插入到搜索引擎ES中
                esRepository.saveItemList(itemList);
                //下一页
                pageIndex += pageSize;
            } while (itemList.size() == pageSize); //拿出一整页的数据，可能还有数据
        } catch (Exception e) {
            log.error("error", e);
        }
        log.warn("finish item sync");
    }
}
