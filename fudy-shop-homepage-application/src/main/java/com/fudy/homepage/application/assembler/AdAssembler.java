package com.fudy.homepage.application.assembler;

import com.fudy.homepage.application.dto.AdDTO;
import com.fudy.homepage.domain.ad.Ad;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AdAssembler {

    AdDTO toAdDTO(Ad ad);

    List<AdDTO> toAdDTOList(List<Ad> adList);
}
