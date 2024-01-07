package com.fudy.homepage.domain.model.search;

import lombok.Getter;

@Getter
public enum SortField {
    PRICE("price");

    private String value;

    SortField(String value) {
        this.value = value;
    }

    public static SortField of(String str) {package com.fudy.homepage.domain.model.search;

import lombok.Getter;

        @Getter
        public enum SortField {
            PRICE("price");

            private String value;

            SortField(String value) {
                this.value = value;
            }

            public static com.fudy.homepage.domain.model.search.SortField of(String str) {
                for (com.fudy.homepage.domain.model.search.SortField f : com.fudy.homepage.domain.model.search.SortField.values()) {
                    if (f.value.equals(str)) {
                        return f;
                    }
                }
                return null;
            }
        }

        for (SortField f : SortField.values()) {
            if (f.value.equals(str)) {
                return f;
            }
        }
        return null;
    }
}
