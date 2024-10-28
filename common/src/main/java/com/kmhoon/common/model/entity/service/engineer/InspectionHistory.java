package com.kmhoon.common.model.entity.service.engineer;

import com.kmhoon.common.model.entity.service.vendingMachine.VendingMachine;
import com.kmhoon.common.model.entity.service.vendor.Vendor;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Comment;
import org.hibernate.proxy.HibernateProxy;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * 자판기 점검이력
 */
@Entity
@Table(name = "tb_service_inspection_history")
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class InspectionHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sequence;

    @Comment("점검한자판기")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vendING_machine_seq")
    private VendingMachine vendingMachine;

    @Comment("점검한엔지니어")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "delivery_man_seq")
    private Engineer engineer;

    @Comment("점검일자")
    private LocalDateTime inspectionDate;

    @Comment("문제여부")
    private boolean isProblem;

    @Comment("내용")
    @Column(columnDefinition = "TEXT")
    private String note;

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        InspectionHistory that = (InspectionHistory) o;
        return getSequence() != null && Objects.equals(getSequence(), that.getSequence());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
}
