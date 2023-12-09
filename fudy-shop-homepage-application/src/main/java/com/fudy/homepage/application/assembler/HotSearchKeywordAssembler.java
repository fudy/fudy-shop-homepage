package com.fudy.homepage.application.assembler;

import com.fudy.homepage.application.dto.HotSearchKeywordDTO;
import com.fudy.homepage.domain.search.Keyword;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface HotSearchKeywordAssembler {

    default HotSearchKeywordDTO toHotSearchKeywordDTO(Keyword keyword) {
        HotSearchKeywordDTO dto = new HotSearchKeywordDTO();
        dto.setKeyword(keyword.getValue());
        return dto;
    }

    List<HotSearchKeywordDTO> toHotSearchKeywordDTOList(List<Keyword> keywords);
}
