package com.fudy.homepage.application;

import com.fudy.homepage.domain.item.ItemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ItemSyncManager {

    @Autowired
    private ItemService itemService;

    public void execute() {
        itemService.syncItemFromDB2ES();
    }
}
