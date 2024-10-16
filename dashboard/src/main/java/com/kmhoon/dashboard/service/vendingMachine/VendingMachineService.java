package com.kmhoon.dashboard.service.vendingMachine;

import com.kmhoon.common.model.dto.service.vendingMachine.CreateVendingMachineRequest;
import com.kmhoon.common.model.entity.auth.user.User;
import com.kmhoon.common.model.entity.service.vendingMachine.VendingMachine;
import com.kmhoon.common.repository.auth.user.UserRepository;
import com.kmhoon.common.repository.service.delivery.DeliveryManRepository;
import com.kmhoon.common.repository.service.engineer.EngineerRepository;
import com.kmhoon.common.repository.service.vendingMachine.VendingMachineRepository;
import com.kmhoon.common.repository.service.vendor.VendorRepository;
import com.kmhoon.dashboard.exception.DashboardApiException;
import com.kmhoon.dashboard.utils.DateTimeUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

import static com.kmhoon.dashboard.exception.service.vendingMachine.VendingMachineErrorCode.*;

@Service
@RequiredArgsConstructor
public class VendingMachineService {

    private final VendingMachineRepository vendingMachineRepository;
    private final UserRepository userRepository;
    private final VendorRepository vendorRepository;
    private final EngineerRepository engineerRepository;
    private final DeliveryManRepository deliveryManRepository;

    @Transactional
    public void createVendingMachine(CreateVendingMachineRequest request) {
        if(vendingMachineRepository.existsByCode(request.getCode())) {
            throw new DashboardApiException(CODE_EXISTED);
        }

        VendingMachine newVendingMachine = VendingMachine.builder()
                .code(request.getCode())
                .name(request.getName())
                .address(request.getAddress())
                .locationX(Double.parseDouble(request.getLocationX()))
                .locationY(Double.parseDouble(request.getLocationY()))
                .status(request.getStatus())
                .vendingMachineTypeList(request.getVendingMachineTypeList())
                .manager(userRepository.findById(request.getManagerSeq()).orElseThrow(() -> new DashboardApiException(MANAGER_SEQ_NOT_FOUND)))
                .vendor(Objects.isNull(request.getVendorSeq()) ? null : vendorRepository.findById(request.getVendorSeq()).orElseThrow(() -> new DashboardApiException(VENDOR_SEQ_NOT_FOUND)))
                .engineer(Objects.isNull(request.getEngineerSeq()) ? null : engineerRepository.findById(request.getEngineerSeq()).orElseThrow(() -> new DashboardApiException(ENGINEER_SEQ_NOT_FOUND)))
                .deliveryMan(Objects.isNull(request.getDeliveryManSeq()) ? null : deliveryManRepository.findById(request.getDeliveryManSeq()).orElseThrow(() -> new DashboardApiException(DELIVERY_MAN_SEQ_NOT_FOUND)))
                .nextInspectionDate(DateTimeUtil.strToLocalDate(request.getNextInspectionDate()))
                .build();

        vendingMachineRepository.save(newVendingMachine);
    }
}
