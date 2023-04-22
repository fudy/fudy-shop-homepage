package com.fudy.homepage.interfaces.http;

import com.fudy.homepage.interfaces.dto.Result;
import com.fudy.homepage.interfaces.dto.SimpleItemDTO;
import com.fudy.homepage.interfaces.manager.ItemManagerInterface;
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
    private ItemManagerInterface itemManager;

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
}
