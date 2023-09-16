package com.fudy.homepage.infrastructure.nacos;

import com.alibaba.nacos.api.annotation.NacosInjected;
import com.alibaba.nacos.api.annotation.NacosProperties;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.config.annotation.NacosConfigListener;
import com.alibaba.nacos.spring.context.annotation.EnableNacos;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fudy.homepage.domain.ad.Ad;
import com.fudy.homepage.domain.ad.AdType;
import com.fudy.homepage.domain.repository.AdRepository;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.List;

@Slf4j
@Configuration
@EnableNacos(globalProperties = @NacosProperties(serverAddr =  "${spring.cloud.nacos.config.server-addr}"))
public class HomePageAdConfig implements AdRepository  {
    private final String DATA_ID = "fudy-shop-homepage-ad";
    private final String GROUP = "DEFAULT_GROUP";
    @NacosInjected
    private ConfigService configService;

    @Getter
    private List<Ad> data;

    private List<Ad> getData(String content) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(content, new TypeReference<>() {});
    }

    @PostConstruct
    public void init() throws Exception {
        String content = configService.getConfig(DATA_ID, GROUP, 5000);
        this.data = this.getData(content);
    }

    @NacosConfigListener(dataId = DATA_ID)
    public void onMessage(String content) {
        try {
            this.data = this.getData(content);
        } catch (Exception e) {
            log.error("get data error: {}", e);
        }
    }

    @Override
    public List<Ad> getAdList() {
        return this.data;
    }

    @Override
    public AdType getType() {
        return AdType.HOME_PAGE_AD;
    }
}
