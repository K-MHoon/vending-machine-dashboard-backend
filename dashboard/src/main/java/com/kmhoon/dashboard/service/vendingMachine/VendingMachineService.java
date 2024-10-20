package com.kmhoon.dashboard.service.vendingMachine;

import com.kmhoon.common.model.dto.service.vendingMachine.CreateVendingMachineRequest;
import com.kmhoon.common.model.dto.service.vendingMachine.UpdateVendingMachineRequest;
import com.kmhoon.common.model.entity.service.delivery.DeliveryMan;
import com.kmhoon.common.model.entity.service.engineer.Engineer;
import com.kmhoon.common.model.entity.service.vendingMachine.VendingMachine;
import com.kmhoon.common.model.entity.service.vendor.Vendor;
import com.kmhoon.common.repository.auth.user.UserRepository;
import com.kmhoon.common.repository.service.delivery.DeliveryManRepository;
import com.kmhoon.common.repository.service.engineer.EngineerRepository;
import com.kmhoon.common.repository.service.vendingMachine.VendingMachineRepository;
import com.kmhoon.common.repository.service.vendor.VendorRepository;
import com.kmhoon.dashboard.exception.DashboardApiException;
import com.kmhoon.dashboard.utils.DateTimeUtil;
import com.kmhoon.dashboard.utils.SecurityUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
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
                .locationX(request.getLocationX())
                .locationY(request.getLocationY())
                .status(request.getStatus())
                .isUse(request.getIsUse())
                .isDelete(Boolean.FALSE)
                .vendingMachineTypeList(request.getVendingMachineTypeList())
                .manager(userRepository.findByEmail(SecurityUtils.getLoggedInUserId()).orElseThrow(() -> new DashboardApiException(MANAGER_SEQ_NOT_FOUND)))
                .vendor(getVendor(request.getVendorSeq()))
                .engineer(getEngineer(request.getEngineerSeq()))
                .deliveryMan(getDeliveryMan(request.getDeliveryManSeq()))
                .nextInspectionDate(getNextInspectionDate(request.getNextInspectionDate()))
                .build();

        vendingMachineRepository.save(newVendingMachine);
    }

    @Transactional
    public void updateVendingMachine(UpdateVendingMachineRequest request) {
        VendingMachine vendingMachine = vendingMachineRepository.findById(request.getSeq()).orElseThrow(() -> new DashboardApiException(VENDING_MACHINE_NOT_FOUND));

        if(!vendingMachine.getCode().equals(request.getCode()) && vendingMachineRepository.existsByCodeAndIsDeleteIsFalse(request.getCode())) {
            throw new DashboardApiException(CODE_EXISTED);
        }

        vendingMachine.updateAll(request.getCode(),
                request.getName(),
                request.getLocationX(),
                request.getLocationY(),
                request.getAddress(),
                request.getIsUse(),
                request.getStatus(),
                request.getVendingMachineTypeList(),
                getVendor(request.getVendorSeq()),
                getEngineer(request.getEngineerSeq()),
                getDeliveryMan(request.getDeliveryManSeq()),
                getNextInspectionDate(request.getNextInspectionDate()));
    }

    private static LocalDate getNextInspectionDate(String request) {
        return DateTimeUtil.strToLocalDate(request);
    }

    private DeliveryMan getDeliveryMan(Long request) {
        return Objects.isNull(request) ? null : deliveryManRepository.findById(request).orElseThrow(() -> new DashboardApiException(DELIVERY_MAN_SEQ_NOT_FOUND));
    }

    private Engineer getEngineer(Long request) {
        return Objects.isNull(request) ? null : engineerRepository.findById(request).orElseThrow(() -> new DashboardApiException(ENGINEER_SEQ_NOT_FOUND));
    }

    private Vendor getVendor(Long request) {
        return Objects.isNull(request) ? null : vendorRepository.findById(request).orElseThrow(() -> new DashboardApiException(VENDOR_SEQ_NOT_FOUND));
    }

}
