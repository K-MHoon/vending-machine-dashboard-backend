package com.kmhoon.dashboard.service.vendor;

import com.kmhoon.common.model.dto.service.vendor.CreateVendorRequest;
import com.kmhoon.common.model.dto.service.vendor.UpdateVendorRequest;
import com.kmhoon.common.model.entity.service.vendor.Vendor;
import com.kmhoon.common.repository.service.vendor.VendorRepository;
import com.kmhoon.dashboard.exception.DashboardApiException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.kmhoon.dashboard.exception.service.vendor.VendorErrorCode.VENDOR_SEQ_NOT_FOUND;

@Service
@RequiredArgsConstructor
public class VendorService {

    private final VendorRepository vendorRepository;

    @Transactional
    public void createVendor(CreateVendorRequest request) {
        Vendor vendor = Vendor.builder()
                .name(request.getName())
                .address(request.getAddress())
                .isUse(request.getIsUse())
                .phoneNumber(request.getPhoneNumber())
                .build();

        vendorRepository.save(vendor);
    }

    @Transactional
    public void updateVendor(UpdateVendorRequest request) {
        Vendor vendor = vendorRepository.findById(request.getSeq()).orElseThrow(() -> new DashboardApiException(VENDOR_SEQ_NOT_FOUND));
        vendor.updateAll(request.getName(), request.getPhoneNumber(), request.getAddress(), request.getIsUse());
    }
}
