package com.fudy.homepage.infrastructure.mybatis.repository;

import com.fudy.homepage.domain.repository.AdRepository;
import com.fudy.homepage.domain.Ad;
import com.fudy.homepage.infrastructure.nacos.HomePageAdConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("homePageAd")
public class HomePageAdRepository implements AdRepository {
    @Autowired
    private HomePageAdConfig config;

    @Override
    public List<Ad> getAdList() {
        return config.getData();
    }
}
