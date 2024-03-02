package com.fudy.homepage.domain.model.search;

import lombok.Getter;

@Getter
public enum SortField {
    PRICE("price");

    private String value;

    SortField(String value) {
        this.value = value;
    }

    public static SortField of(String str) {
        for (SortField f : SortField.values()) {
            if (f.value.equals(str)) {
                return f;
            }
        }
        return null;
    }
}