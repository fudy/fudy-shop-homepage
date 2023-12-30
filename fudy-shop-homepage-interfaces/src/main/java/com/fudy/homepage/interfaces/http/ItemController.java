package com.fudy.homepage.interfaces.http;

import com.fudy.homepage.application.ItemManager;
import com.fudy.homepage.application.dto.CategoryItemSearchQuery;
import com.fudy.homepage.application.dto.ItemSearchQuery;
import com.fudy.homepage.application.dto.Result;
import com.fudy.homepage.application.dto.SimpleItemDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Slf4j
@Controller
public class ItemController {
    @Autowired
    private ItemManager itemManager;

    /**
     * 获取首页商品列表
     */
    @GetMapping("/api/items")
    public @ResponseBody Result<List<SimpleItemDTO>> getItemList(@RequestParam("pageIndex") Integer pageIndex,
                                                                 @RequestParam("pageSize") Integer pageSize) {
        try {
            List<SimpleItemDTO> data = itemManager.getItemList(pageIndex, pageSize);
            return Result.success(data);
        } catch (Exception e) {
            log.error(e.getMessage());
            return Result.fail(e.getMessage());
        }
    }

    @GetMapping("/api/search/items")
    public @ResponseBody Result<List<SimpleItemDTO>> searchItems(ItemSearchQuery query) {
        try {
            List<SimpleItemDTO> data = itemManager.search(query);
            return Result.success(data);
        } catch (Exception e) {
            log.error(e.getMessage());
            return Result.fail(e.getMessage());
        }
    }

    @GetMapping("/api/category-search/items")
    public @ResponseBody Result<List<SimpleItemDTO>> searchItemsInCategory(CategoryItemSearchQuery query) {
        try {
            List<SimpleItemDTO> data = itemManager.searchItemsInCategory(query);
            return Result.success(data);
        } catch (Exception e) {
            log.error(e.getMessage());
            return Result.fail(e.getMessage());
        }
    }
}
