package com.kmhoon.dashboard.controller;

import com.kmhoon.common.model.dto.service.vendingMachine.CreateVendingMachineRequest;
import com.kmhoon.dashboard.service.vendingMachine.VendingMachineService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/service")
public class VendingMachineController {

    private final VendingMachineService service;

    @PostMapping("/vending-machine")
    @ResponseStatus(HttpStatus.OK)
    public void createVendingMachine(@RequestBody @Validated CreateVendingMachineRequest request) {
        service.createVendingMachine(request);
    }
}
