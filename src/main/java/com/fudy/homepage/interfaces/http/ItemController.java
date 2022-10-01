package com.fudy.homepage.interfaces.http;

import com.fudy.homepage.application.ItemManager;
import com.fudy.homepage.interfaces.dto.PaginationQuery;
import com.fudy.homepage.interfaces.dto.Result;
import com.fudy.homepage.interfaces.dto.SimpleItemDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Slf4j
@Controller
public class ItemController {
    @Autowired
    private ItemManager itemManager;
    @Autowired
    private HttpServletRequest request;

    /**
     * 获取首页商品列表
     */
    @GetMapping("/api/items")
    public @ResponseBody Result<List<SimpleItemDTO>> getItemList(@RequestParam("pageIndex") Integer pageIndex,
                                                                 @RequestParam("pageSize") Integer pageSize) {
        try {
            List<SimpleItemDTO> data = itemManager.getItemList(new PaginationQuery(pageIndex, pageSize));
            return Result.success(data);
        } catch (Exception e) {
            log.error(e.getMessage());
            return Result.fail(e.getMessage());
        }
    }
}
