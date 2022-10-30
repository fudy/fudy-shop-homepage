package com.fudy.homepage.interfaces.http;

import com.fudy.homepage.application.AdManager;
import com.fudy.homepage.interfaces.dto.AdDTO;
import com.fudy.homepage.interfaces.dto.ItemCategoryLineDTO;
import com.fudy.homepage.interfaces.dto.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Slf4j
@Controller
public class AdController {
    @Autowired
    private AdManager adManager;
    /**
     * 获取首页广告
     */
    @GetMapping("/api/ad-list")
    public @ResponseBody
    Result<List<AdDTO>> getAdList(String type) {
        try {
            List<AdDTO> data = adManager.getAdList(type);
            return Result.success(data);
        } catch (Exception e) {
            log.error(e.getMessage());
            return Result.fail(e.getMessage());
        }
    }
}
