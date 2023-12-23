package com.fudy.homepage.infrastructure.convertor;

import com.fudy.homepage.domain.model.ID;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EntityConvertor {
    default ID toID(Long id) {
        return null == id ? null : new ID(id);
    }
}
