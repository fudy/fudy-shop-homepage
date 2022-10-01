package com.fudy.homepage.infrastructure.mybatis.mapper;

import com.fudy.homepage.infrastructure.mybatis.data.ItemDO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

@SpringBootTest
public class ItemMapperTest {
    @Autowired
    private ItemMapper mapper;

    @Test
    public void testSelectList() {
        List<ItemDO> list = mapper.selectList(0, 20);
        assertFalse(list.isEmpty());
        for (ItemDO itemDO : list) {
            System.out.println(itemDO.getName());
        }
    }
}
