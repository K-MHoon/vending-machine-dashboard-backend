package com.kmhoon.common.repository.service.vendingMachine;

import com.kmhoon.common.model.entity.service.vendingMachine.VendingMachine;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VendingMachineRepository extends JpaRepository<VendingMachine, Long> {

    boolean existsByCode(String code);
    boolean existsByCodeAndIsDeleteIsFalse(String code);
    Optional<VendingMachine> findBySequenceAndIsDeleteIsFalse(Long seq);
}
