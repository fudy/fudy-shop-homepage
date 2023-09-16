package com.fudy.homepage.interfaces.job;

import com.fudy.homepage.application.ItemSyncManager;
import com.xxl.job.core.handler.annotation.XxlJob;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ItemSyncJob {
    @Autowired
    private ItemSyncManager manager;

    @XxlJob("itemSyncJobHandler")
    public void execute() throws Exception {
        manager.execute();
    }
}
