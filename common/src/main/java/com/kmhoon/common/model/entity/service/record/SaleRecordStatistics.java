package com.kmhoon.common.model.entity.service.record;

import com.kmhoon.common.model.entity.service.group.ManagerGroup;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Comment;

import java.time.LocalDate;

/**
 * 자판기 물품 매출 요약 정보
 */
@Entity
@Table(name = "tb_service_sale_record_statistics")
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class SaleRecordStatistics {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sequence;

    @Comment("보고서요약관련월")
    private LocalDate reportDate;

    @Comment("전체매출")
    private Long totalRevenue;

    @Comment("전월대비매출증감율")
    private Double mom;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "manger_group_seq")
    private ManagerGroup managerGroup;
}
