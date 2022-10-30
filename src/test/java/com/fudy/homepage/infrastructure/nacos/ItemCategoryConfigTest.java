package com.fudy.homepage.infrastructure.nacos;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ItemCategoryConfigTest {
    @Autowired
    private ItemCategoryConfig config;

    @Test
    public void testGetContent() {
        System.out.println("content: "+config.getData());
    }
}
