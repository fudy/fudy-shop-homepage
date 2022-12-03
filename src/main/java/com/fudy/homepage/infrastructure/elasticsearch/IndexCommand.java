package com.fudy.homepage.infrastructure.elasticsearch;

import lombok.Data;

@Data
public class IndexCommand {
    private String id;

    private String index;

    private Object doc;
}
