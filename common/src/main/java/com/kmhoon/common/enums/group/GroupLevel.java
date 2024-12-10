package com.kmhoon.common.enums.group;

import lombok.Getter;

@Getter
public enum GroupLevel {

    PREMIUM("프리미엄"),
    VIP("VIP"),
    NORMAL("일반");

    private final String description;

    GroupLevel(String description) {
        this.description = description;
    }
}
