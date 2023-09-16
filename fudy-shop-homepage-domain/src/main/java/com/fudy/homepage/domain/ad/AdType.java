package com.fudy.homepage.domain.ad;

public enum AdType {
    HOME_PAGE_AD("homePageAd"),
    SUPER_DEAL_AD("superDealAd");

    private String value;

    AdType(String value) {
        this.value = value;
    }

    public static AdType of(String value) {
        for (AdType type : AdType.values()) {
            if (type.value.equals(value)) {
                return type;
            }
        }
        return null;
    }
}
