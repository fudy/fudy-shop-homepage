package com.fudy.homepage.application;

import com.fudy.homepage.application.assembler.AdAssembler;
import com.fudy.homepage.domain.repository.AdRepository;
import com.fudy.homepage.interfaces.dto.AdDTO;
import com.fudy.homepage.interfaces.manager.AdManagerInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service
public class AdManager implements AdManagerInterface {
    @Autowired
    private Map<String, AdRepository> adRepositoryMap;
    @Autowired
    private AdAssembler assembler;

    public List<AdDTO> getAdList(String type) {
        AdRepository adRepository = adRepositoryMap.get(type);
        Objects.requireNonNull(adRepository, "can't find repository of type :" + type);
        return assembler.toAdDTOList(adRepository.getAdList());
    }

}
