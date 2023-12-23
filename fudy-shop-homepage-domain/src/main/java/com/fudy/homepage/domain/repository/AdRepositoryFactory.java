package com.fudy.homepage.domain.repository;

import com.fudy.homepage.domain.model.ad.AdType;
import com.fudy.homepage.domain.repository.AdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class AdRepositoryFactory {
    private Map<AdType, AdRepository> map;

    @Autowired
    public AdRepositoryFactory(Map<AdType, AdRepository> map) {
        this.map = map;
    }

    public AdRepository getAdRepository(AdType type) {
        if (null == map || null == type) {
            return null;
        }
        return map.get(type);
    }
}
