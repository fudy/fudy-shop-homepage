package com.fudy.homepage.infrastructure.mybatis.repository;

import com.fudy.homepage.domain.repository.AdRepository;
import com.fudy.homepage.domain.Ad;
import com.fudy.homepage.infrastructure.nacos.SuperDealAdConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("superDealAd")
public class SuperDealAdRepository implements AdRepository {
    @Autowired
    private SuperDealAdConfig config;

    @Override
    public List<Ad> getAdList() {
        return config.getData();
    }
}
