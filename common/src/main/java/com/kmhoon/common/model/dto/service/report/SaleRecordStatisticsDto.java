package com.kmhoon.common.model.dto.service.report;

import com.kmhoon.common.model.entity.service.record.SaleRecordStatistics;
import lombok.*;

import java.time.LocalDate;

@Getter
@ToString
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class SaleRecordStatisticsDto {

    private Long sequence;
    private LocalDate reportDate;
    private Double totalRevenue;
    private Double mom;

    public static SaleRecordStatisticsDto of(SaleRecordStatistics saleRecordStatistics) {
        return SaleRecordStatisticsDto.builder()
                .sequence(saleRecordStatistics.getSequence())
                .reportDate(saleRecordStatistics.getReportDate())
                .totalRevenue(saleRecordStatistics.getTotalRevenue())
                .mom(saleRecordStatistics.getMom())
                .build();
    }
}
