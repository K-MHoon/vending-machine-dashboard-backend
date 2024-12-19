package com.kmhoon.common.repository.service.record;

import com.kmhoon.common.model.entity.service.group.ManagerGroup;
import com.kmhoon.common.model.entity.service.record.SaleRecordStatistics;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface SaleRecordStatisticsRepository extends JpaRepository<SaleRecordStatistics, Long> {

    List<SaleRecordStatistics> findAllByManagerGroupAndReportDateBetween(ManagerGroup managerGroup, LocalDate start, LocalDate end);
}
