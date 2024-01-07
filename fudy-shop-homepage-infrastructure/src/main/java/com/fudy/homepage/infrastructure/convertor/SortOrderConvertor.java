package com.fudy.homepage.infrastructure.convertor;

import com.fudy.homepage.domain.model.search.SortOrder;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SortOrderConvertor {
    default co.elastic.clients.elasticsearch._types.SortOrder toSortOrder(SortOrder sortOrder) {
        if (null == sortOrder) {
            return null;
        }
        if (sortOrder == SortOrder.DESC) {
            return co.elastic.clients.elasticsearch._types.SortOrder.Desc;
        }
        return co.elastic.clients.elasticsearch._types.SortOrder.Asc;
    }
}
