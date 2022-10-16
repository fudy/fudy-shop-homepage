package com.fudy.homepage.application;

import com.fudy.homepage.interfaces.dto.PaginationQuery;
import com.fudy.homepage.interfaces.dto.SimpleItemDTO;
import net.minidev.json.JSONArray;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ItemManagerTest {
    @Autowired
    private ItemManager manager;

    @Test
    public void testGetItemList() {
        PaginationQuery query = new PaginationQuery(0, 10);
        List<SimpleItemDTO> list = manager.getItemList(query);
        System.out.println(JSONArray.toJSONString(list));
    }
}
