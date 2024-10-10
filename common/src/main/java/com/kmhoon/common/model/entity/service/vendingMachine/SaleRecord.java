package com.kmhoon.common.model.entity.service.vendingMachine;

import com.kmhoon.common.enums.PaymentMethod;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Comment;

import java.time.LocalDateTime;

/**
 * 자판기 물품 판매 정보
 */
@Entity
@Table(name = "tb_service_sold_history")
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class SaleRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sequence;

    @Comment("판매시간")
    private LocalDateTime soldTime;

    @Comment("판매된시점의가격")
    private long price;

    @Comment("결제방식")
    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;

    @ManyToOne(fetch = FetchType.LAZY)
    private VendingMachineProductMap vendingMachineItemMap;
}
