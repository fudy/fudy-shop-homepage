package com.fudy.homepage.domain.model.search;

import lombok.Getter;

@Getter
public class Keyword {
    private final String value;

    public Keyword(String value) {
        this.value = value;
    }
}
