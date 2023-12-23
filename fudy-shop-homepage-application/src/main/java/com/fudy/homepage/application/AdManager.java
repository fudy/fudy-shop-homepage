package com.fudy.homepage.application;

import com.fudy.homepage.application.assembler.AdAssembler;
import com.fudy.homepage.application.dto.AdDTO;
import com.fudy.homepage.domain.service.AdService;
import com.fudy.homepage.domain.model.ad.AdType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdManager {
    @Autowired
    private AdService adService;
    @Autowired
    private AdAssembler assembler;

    public List<AdDTO> getAdList(String type) {
        AdType adType = AdType.of(type);
        return assembler.toAdDTOList(adService.getAdList(adType));
    }

}
