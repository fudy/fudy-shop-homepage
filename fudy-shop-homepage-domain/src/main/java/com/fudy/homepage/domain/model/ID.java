package com.fudy.homepage.domain.model;

import lombok.Getter;

public class ID implements Identifier<Long> {
    @Getter
    private final Long value;

    public ID(Long value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return ""+value;
    }
}
