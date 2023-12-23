package com.fudy.homepage.infrastructure.nacos;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.nacos.api.annotation.NacosInjected;
import com.alibaba.nacos.api.annotation.NacosProperties;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.config.annotation.NacosConfigListener;
import com.alibaba.nacos.spring.context.annotation.EnableNacos;
import com.fudy.homepage.domain.repository.KeywordRepository;
import com.fudy.homepage.domain.model.search.Keyword;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.CollectionUtils;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Configuration
@EnableNacos(globalProperties = @NacosProperties(serverAddr =  "${spring.cloud.nacos.config.server-addr}"))
public class HotSearchKeywordConfig implements KeywordRepository {
    private final String DATA_ID = "fudy-shop-homepage-hot-search-keyword";
    private final String GROUP = "DEFAULT_GROUP";
    @NacosInjected
    private ConfigService configService;
    @Getter
    private List<Keyword> keywords;

    /** 程序启动时主动去获取配置 */
    @PostConstruct
    public void init() throws Exception {
        String content = configService.getConfig(DATA_ID, GROUP, 5000);
        this.keywords = parseContent(content);
    }

    /** 程序运行时，如果修改了配置，则实时更新 */
    @NacosConfigListener(dataId = DATA_ID)
    public void onMessage(String content) {
        try {
            this.keywords = parseContent(content);
        } catch (Exception e) {
            log.error("get data error: {}", e);
        }
    }

    /** 从配置内容中解析出热搜关键词 */
    private List<Keyword> parseContent(String content) {
        if (null == content) {
            return null;
        }
        JSONObject data = JSON.parseObject(content);
        JSONArray keywords = data.getJSONArray("keywords");
        if (CollectionUtils.isEmpty(keywords)) {
            return null;
        }
        List<Keyword> list = new ArrayList<>();
        for (Object keyword : keywords) {
            list.add(new Keyword((String)keyword));
        }
        return list;
    }

    @Override
    public List<Keyword> getKeywordList() {
        return keywords;
    }
}
