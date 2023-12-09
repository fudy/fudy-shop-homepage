package com.fudy.homepage.interfaces.http;

import com.fudy.homepage.application.HotSearchKeywordManager;
import com.fudy.homepage.application.dto.HotSearchKeywordDTO;
import com.fudy.homepage.application.dto.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Slf4j
@Controller
public class HotSearchKeywordController {
    @Autowired
    private HotSearchKeywordManager manager;

    /**
     * 获取首页商品列表
     */
    @GetMapping("/api/hot-search-keywords")
    public @ResponseBody
    Result<List<HotSearchKeywordDTO>> getHotSearchKeywords() {
        try {
            List<HotSearchKeywordDTO> data = manager.getHotSearchKeywords();
            return Result.success(data);
        } catch (Exception e) {
            log.error(e.getMessage());
            return Result.fail(e.getMessage());
        }
    }

}
