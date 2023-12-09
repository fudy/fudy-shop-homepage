package com.fudy.homepage.domain.search;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Keyword {
    private final String value;

    public Keyword(String value) {
        this.value = value;
    }
}
