package com.kmhoon.common.model.entity.service.delivery;

import com.kmhoon.common.model.entity.service.vendingMachine.VendingMachine;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Comment;
import org.hibernate.proxy.HibernateProxy;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * 물품 배송 이력
 */
@Entity
@Table(name = "tb_service_delivery_history")
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class DeliveryHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sequence;

    @Comment("배달일자")
    private LocalDateTime deliveryDateTime;

    @Comment("배달기사")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "delivery_man_seq")
    private DeliveryMan deliveryMan;

    @Comment("배달한자판기")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vending_machine_seq")
    private VendingMachine vendingMachine;

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        DeliveryHistory that = (DeliveryHistory) o;
        return getSequence() != null && Objects.equals(getSequence(), that.getSequence());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
}
