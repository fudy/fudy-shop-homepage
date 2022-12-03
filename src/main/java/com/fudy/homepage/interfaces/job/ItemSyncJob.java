package com.fudy.homepage.interfaces.job;

import com.fudy.homepage.application.repository.ItemRepository;
import com.fudy.homepage.domain.Item;
import com.fudy.homepage.interfaces.dto.PaginationQuery;
import com.xxl.job.core.handler.annotation.XxlJob;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class ItemSyncJob {
    @Autowired @Qualifier("DBItemRepository")
    private ItemRepository dbRepository;

    @Autowired @Qualifier("ESItemRepository")
    private ItemRepository esRepository;

    @XxlJob("itemSyncJobHandler")
    public void execute() throws Exception {
        log.warn("start item sync");
        List<Item> itemList = null;
        int pageIndex = 0, pageSize = 100;
        do {
            PaginationQuery query = new PaginationQuery(pageIndex, pageSize);
            //从DB读取数据
            itemList = dbRepository.getItemList(query);
            //将数据插入到搜索引擎ES中
            esRepository.saveItemList(itemList);
            //下一页
            pageIndex += pageSize;
        } while (itemList.size() == pageSize); //拿出一整页的数据，可能还有数据
        log.warn("finish item sync");
    }
}
