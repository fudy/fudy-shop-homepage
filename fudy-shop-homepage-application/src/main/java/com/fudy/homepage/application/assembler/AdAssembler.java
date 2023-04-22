package com.fudy.homepage.application.assembler;

import com.fudy.homepage.domain.Ad;
import com.fudy.homepage.interfaces.dto.AdDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AdAssembler {

    AdDTO toAdDTO(Ad ad);

    List<AdDTO> toAdDTOList(List<Ad> adList);
}
