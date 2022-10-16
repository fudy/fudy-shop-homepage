package com.fudy.homepage.infrastructure.elasticsearch;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch._types.SortOrder;
import co.elastic.clients.elasticsearch.core.SearchResponse;
import co.elastic.clients.elasticsearch.core.search.Hit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ElasticSearchFacade {
    @Autowired
    private ElasticsearchClient client;

    public <T> List<T> pagingSearch(ESPagingQuery query, Class<T> clazz) throws IOException {
        SearchResponse<T> resp = client.search(req -> req.index(query.getIndex())
                        .from(query.getFrom())
                        .size(query.getSize())
                        .sort(f -> f.field(o -> o.field(query.getSortField()).order(SortOrder.Asc)))
                , clazz);
        List<Hit<T>> list = resp.hits().hits();
        if (null == list) {
            return null;
        }
        List<T> resultList = new ArrayList<>();
        for (Hit<T> hit : list) {
            resultList.add(hit.source());
        }
        return resultList;
    }

}
