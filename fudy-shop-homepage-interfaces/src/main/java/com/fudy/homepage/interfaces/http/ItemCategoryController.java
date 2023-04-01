package com.fudy.homepage.interfaces.http;

import com.fudy.homepage.application.assembler.ItemCategoryLineAssembler;
import com.fudy.homepage.infrastructure.nacos.ItemCategoryConfig;
import com.fudy.homepage.application.dto.ItemCategoryLineDTO;
import com.fudy.homepage.application.dto.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Slf4j
@Controller
public class ItemCategoryController {
    @Autowired
    private ItemCategoryConfig config;
    @Autowired
    private ItemCategoryLineAssembler assembler;

    /**
     * 获取首页商品列表
     */
    @GetMapping("/api/item-categories")
    public @ResponseBody Result<List<ItemCategoryLineDTO>> getItemCategoryList() {
        try {
            List<ItemCategoryLineDTO> data = assembler.toItemCategoryLineDTOList(config.getData());
            return Result.success(data);
        } catch (Exception e) {
            log.error(e.getMessage());
            return Result.fail(e.getMessage());
        }
    }
}
