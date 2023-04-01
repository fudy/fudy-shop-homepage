package com.fudy.homepage.application.repository.impl;

import com.fudy.homepage.application.assembler.AdAssembler;
import com.fudy.homepage.application.repository.AdRepository;
import com.fudy.homepage.infrastructure.nacos.SuperDealAdConfig;
import com.fudy.homepage.application.dto.AdDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("superDealAd")
public class SuperDealAdRepository implements AdRepository {
    @Autowired
    private SuperDealAdConfig config;
    @Autowired
    private AdAssembler assembler;

    @Override
    public List<AdDTO> getAdList() {
        return assembler.toAdDTOList(config.getData());
    }
}
