package com.kmhoon.common.model.dto.service.vendingMachine;

import com.kmhoon.common.enums.vendingMachine.VendingMachineStatus;
import com.kmhoon.common.enums.vendingMachine.VendingMachineType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.validator.constraints.UniqueElements;

import java.util.ArrayList;
import java.util.List;

@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public final class UpdateVendingMachineRequest {

    @NotNull
    private Long seq;

    @NotBlank
    private String code;

    @NotBlank
    private String name;

    @NotNull
    private Double locationX;

    @NotNull
    private Double locationY;

    @NotBlank
    private String address;

    @NotNull
    private VendingMachineStatus status;

    @NotNull
    private Boolean isUse;

    @NotNull
    @UniqueElements
    private List<VendingMachineType> vendingMachineTypeList = new ArrayList<>();

    private Long vendorSeq;
    private Long engineerSeq;
    private Long deliveryManSeq;
    private String nextInspectionDate;
}
