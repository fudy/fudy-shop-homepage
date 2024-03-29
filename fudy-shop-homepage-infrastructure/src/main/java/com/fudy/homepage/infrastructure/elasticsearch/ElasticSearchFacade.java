package com.fudy.homepage.infrastructure.elasticsearch;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch._types.SortOptions;
import co.elastic.clients.elasticsearch._types.SortOrder;
import co.elastic.clients.elasticsearch._types.query_dsl.Operator;
import co.elastic.clients.elasticsearch.core.BulkRequest;
import co.elastic.clients.elasticsearch.core.BulkResponse;
import co.elastic.clients.elasticsearch.core.SearchRequest;
import co.elastic.clients.elasticsearch.core.SearchResponse;
import co.elastic.clients.elasticsearch.core.bulk.BulkResponseItem;
import co.elastic.clients.elasticsearch.core.search.Hit;
import co.elastic.clients.util.ObjectBuilder;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;

/**
 * https://www.elastic.co/guide/en/elasticsearch/client/java-api-client/current/getting-started-java.html
 */
@Slf4j
@Service
public class ElasticSearchFacade {
    @Autowired
    private ElasticsearchClient client;

    /**
     * 分页查询
     */
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

    /**
     * 单个创建
     */
    public void index(IndexCommand command) throws IOException {
        client.index(i -> i.index(command.getIndex())
                .id(command.getId())
                .document(command.getDoc()));
    }

    /**
     * 批量创建
     */
    public void bulkIndex(List<IndexCommand> list) throws IOException {
        Objects.requireNonNull(list, "list should not be null");
        //请求参数构建
        BulkRequest.Builder builder = new BulkRequest.Builder();
        for (IndexCommand cmd : list) {
            builder.operations(op -> op.index(idx -> idx
                    .index(cmd.getIndex())
                    .id(cmd.getId())
                    .document(cmd.getDoc())));
        }
        //执行
        BulkResponse response = client.bulk(builder.build());
        if (response.errors()) {
            log.error("Bulk had errors");
            for (BulkResponseItem item : response.items()) {
                if (item.error() != null) {
                    log.error(item.error().reason());
                }
            }
        }
    }

    /** ES 搜索， keyword中可包含多个关键字 */
    public <T> List<T> search(String indexName, String field, String keyword, String sortField, SortOrder sortOrder, Class<T> clazz) throws IOException {
        Function<SearchRequest.Builder, ObjectBuilder<SearchRequest>> query = req -> {
            req.index(indexName) //index
                    .query(q -> q.match(m -> m.field(field).query(keyword).operator(Operator.Or))); // query
            if (StringUtils.isNotBlank(sortField)) {
                req.sort(SortOptions.of(builder -> builder.field(b -> b.field(sortField).order(sortOrder)))); // sort
            }
            return req;
        };
        SearchResponse<T> resp = client.search(query, clazz);
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
