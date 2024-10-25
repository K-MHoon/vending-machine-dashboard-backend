package com.kmhoon.dashboard.controller.vendor;

import com.kmhoon.common.model.dto.service.vendingMachine.CreateVendingMachineRequest;
import com.kmhoon.common.model.dto.service.vendor.CreateVendorRequest;
import com.kmhoon.dashboard.service.vendor.VendorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/service")
public class VendorController {

    private final VendorService service;

    @PostMapping("/vendor")
    @ResponseStatus(HttpStatus.OK)
    public void createVendor(@RequestBody @Validated CreateVendorRequest request) {
        service.createVendor(request);
    }

}
