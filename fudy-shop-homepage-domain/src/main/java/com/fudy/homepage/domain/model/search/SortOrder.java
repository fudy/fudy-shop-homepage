package com.fudy.homepage.domain.model.search;

public enum SortOrder {
    ASC, DESC;

    public static SortOrder of(String str) {
        for (SortOrder order : SortOrder.values()) {
            if (order.name().equalsIgnoreCase(str)) {
                return order;
            }
        }
        return ASC;
    }
}
