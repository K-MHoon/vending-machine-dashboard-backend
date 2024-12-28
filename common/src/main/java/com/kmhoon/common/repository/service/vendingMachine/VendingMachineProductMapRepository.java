package com.kmhoon.common.repository.service.vendingMachine;

import com.kmhoon.common.model.entity.service.vendingMachine.VendingMachine;
import com.kmhoon.common.model.entity.service.vendingMachine.VendingMachineProductMap;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface VendingMachineProductMapRepository extends JpaRepository<VendingMachineProductMap, Long> {

    @Modifying
    @Query("update VendingMachineProductMap vm set vm.isUse = false where vm.vendingMachine = ?1")
    int updateAllIsUseToFalseByVendingMachineSequence(VendingMachine vendingMachine);
}
