package com.fudy.homepage.infrastructure.elasticsearch;

import co.elastic.clients.elasticsearch._types.SortOrder;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ESPagingQuery {
    private String index;
    private int from;
    private int size;
    private String sortField;
    private SortOrder sortOrder = SortOrder.Asc;
}
