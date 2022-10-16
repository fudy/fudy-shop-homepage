package com.fudy.homepage.infrastructure.elasticsearch;

import co.elastic.clients.elasticsearch._types.SortOrder;
import co.elastic.clients.elasticsearch.core.IndexResponse;
import co.elastic.clients.elasticsearch.core.SearchResponse;
import co.elastic.clients.elasticsearch.core.UpdateResponse;
import co.elastic.clients.elasticsearch.core.search.Hit;
import co.elastic.clients.transport.endpoints.BooleanResponse;
import com.fudy.homepage.domain.Item;
import org.assertj.core.api.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import co.elastic.clients.elasticsearch.ElasticsearchClient;
import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

@SpringBootTest
public class ElasticsearchClientTest {
    @Autowired
    private ElasticsearchClient client;

    @Test
    public void testQueryIndex() throws IOException {
        BooleanResponse response = client.indices().exists(req -> req.index("item"));
        assertTrue(response.value());
    }

    @Test
    public void testCreateDocument() throws IOException {
        Item item = new Item();
        item.setName("飞天茅台");
        item.setPrice(new BigDecimal(1499));
        client.index(req -> req.index("item").id("1").document(item));
    }

    @Test
    public void testUpdateDocument() throws IOException {
        Item item = new Item();
        item.setPrice(new BigDecimal(1499));
        UpdateResponse<Item> resp = client.update(req -> req.index("item").id("1").doc(item), Item.class);
        System.out.println(resp);
    }

    @Test
    public void testSearch() throws IOException {
        SearchResponse<Item> resp = client.search(req -> req.index("item")
                        .query(q -> q.term(t -> t.field("name").value(v -> v.stringValue("茅"))))
                        .from(0)
                        .size(10)
                        .sort(f -> f.field(o -> o.field("price").order(SortOrder.Asc)))
                , Item.class);
        assertNotNull(resp);
        List<Hit<Item>> list = resp.hits().hits();
        for (Hit<Item> hit : list) {
            System.out.println(hit.source().getName());
        }
    }
}
