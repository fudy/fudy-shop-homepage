package com.fudy.homepage;

import com.fudy.homepage.interfaces.dto.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Slf4j
@Controller
public class MainController {

    @GetMapping("/")
    public @ResponseBody
    String root() {
        return "fudy-shop-homepage";
    }
}
