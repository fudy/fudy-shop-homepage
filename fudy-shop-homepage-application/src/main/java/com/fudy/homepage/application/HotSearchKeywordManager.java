package com.fudy.homepage.application;

import com.fudy.homepage.application.assembler.HotSearchKeywordAssembler;
import com.fudy.homepage.application.dto.HotSearchKeywordDTO;
import com.fudy.homepage.domain.repository.KeywordRepository;
import com.fudy.homepage.domain.search.Keyword;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotSearchKeywordManager {
    @Autowired
    private KeywordRepository repository;
    @Autowired
    private HotSearchKeywordAssembler assembler;

    public List<HotSearchKeywordDTO> getHotSearchKeywords() {
        List<Keyword> keywordList = repository.getKeywordList();
        return assembler.toHotSearchKeywordDTOList(keywordList);
    }
}
