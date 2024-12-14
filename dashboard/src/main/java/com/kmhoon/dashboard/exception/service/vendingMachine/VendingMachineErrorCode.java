package com.kmhoon.dashboard.exception.service.vendingMachine;

import com.kmhoon.dashboard.exception.code.ErrorCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum VendingMachineErrorCode implements ErrorCode {

    CODE_EXISTED("S-VENDINGMACHINE-001", HttpStatus.BAD_REQUEST, "이미 존재하는 코드번호 입니다."),
    MANAGER_SEQ_NOT_FOUND("S-VENDINGMACHINE-002", HttpStatus.BAD_REQUEST, "해당하는 매니저를 찾을 수 없습니다."),
    VENDOR_SEQ_NOT_FOUND("S-VENDINGMACHINE-003", HttpStatus.BAD_REQUEST, "해당하는 자판기 제조사를 찾을 수 없습니다."),
    ENGINEER_SEQ_NOT_FOUND("S-VENDINGMACHINE-004", HttpStatus.BAD_REQUEST, "해당하는 엔지니어를 찾을 수 없습니다."),
    DELIVERY_MAN_SEQ_NOT_FOUND("S-VENDINGMACHINE-005", HttpStatus.BAD_REQUEST, "해당하는 배달기사를 찾을 수 없습니다."),
    VENDING_MACHINE_NOT_FOUND("S-VENDINGMACHINE-006", HttpStatus.BAD_REQUEST, "해당하는 자판기 정보를 찾을 수 없습니다."),

    ;

    private final String code;
    private final HttpStatus httpStatus;
    private final String message;
}
