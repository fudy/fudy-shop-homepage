package com.fudy.homepage.domain.service;

import com.fudy.homepage.domain.model.ad.Ad;
import com.fudy.homepage.domain.repository.AdRepositoryFactory;
import com.fudy.homepage.domain.model.ad.AdType;
import com.fudy.homepage.domain.repository.AdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdService {
    private AdRepositoryFactory factory;

    @Autowired
    public AdService(AdRepositoryFactory factory) {
        this.factory = factory;
    }

    public List<Ad> getAdList(AdType type) {
        AdRepository adRepository = factory.getAdRepository(type);
        return null == adRepository ? null : adRepository.getAdList();
    }
}
