package com.kmhoon.dashboard.service.vendor;

import com.kmhoon.common.model.dto.service.vendor.CreateVendorRequest;
import com.kmhoon.common.model.entity.service.vendor.Vendor;
import com.kmhoon.common.repository.service.vendor.VendorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
}
