package com.kmhoon.common.enums;

import lombok.Getter;

@Getter
public enum ProductStatus {
    AVAILABLE("판매 가능"),
    SOLD_OUT("판매 완료"),
    EXPIRED("유통기한 만료"),
    NEAR_EXPIRATION("유통기한 임박"),
    DISCONTINUED("판매 중지"),
    DAMAGED("손상됨");

    private final String description;

    ProductStatus(String description) {
        this.description = description;
    }
}