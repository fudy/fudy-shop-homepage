package com.fudy.homepage.application;

import com.fudy.homepage.application.repository.AdRepository;
import com.fudy.homepage.interfaces.dto.AdDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service
public class AdManager {
    @Autowired
    private Map<String, AdRepository> adRepositoryMap;

    public List<AdDTO> getAdList(String type) {
        AdRepository adRepository = adRepositoryMap.get(type);
        Objects.requireNonNull(adRepository, "can't find repository of type :" + type);
        return adRepository.getAdList();
    }

}
