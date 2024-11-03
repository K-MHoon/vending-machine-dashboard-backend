package com.kmhoon.common.model.dto.service.vendor;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public final class UpdateVendorRequest {

    @NotNull
    private Long seq;
    @NotBlank
    private String name;
    @NotBlank
    private String phoneNumber;
    @NotBlank
    private String address;
    @NotNull
    private Boolean isUse;
}
