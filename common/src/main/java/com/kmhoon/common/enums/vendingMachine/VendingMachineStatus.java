package com.kmhoon.common.enums.vendingMachine;

public enum VendingMachineStatus {
    OPERATIONAL("정상 작동 중"),
    LOW_STOCK("재고 부족"),
    OUT_OF_STOCK("재고 없음"),
    OUT_OF_ORDER("고장"),
    UNDER_MAINTENANCE("유지보수 중"),
    POWERED_OFF("전원 꺼짐"),
    NETWORK_DISCONNECTED("네트워크 연결 끊김"),
    PAYMENT_SYSTEM_ERROR("결제 시스템 오류"),
    TEMPERATURE_ALERT("온도 이상"),
    DOOR_OPEN("문 열림"),
    PRODUCT_JAM("제품 걸림");

    private final String description;

    VendingMachineStatus(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
