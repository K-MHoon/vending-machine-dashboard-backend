package com.kmhoon.common.model.entity.service.vendingMachine;

import com.kmhoon.common.enums.ProductStatus;
import com.kmhoon.common.model.entity.service.Product;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Comment;
import org.hibernate.proxy.HibernateProxy;

import java.util.Objects;

/**
 * 자판기 + 아이템 묶음
 */
@Entity
@Table(name = "tb_service_vending_machine_item_map")
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class VendingMachineProductMap {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sequence;

    @Comment("자판기코드")
    @Column(unique = true)
    private String code;

    @Comment("판매가격")
    private long price;

    @Comment("현재상태")
    @Enumerated(EnumType.STRING)
    private ProductStatus status;

    @Comment("바코드")
    private String barcode;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_seq")
    private Product product;

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
        VendingMachineProductMap that = (VendingMachineProductMap) o;
        return getSequence() != null && Objects.equals(getSequence(), that.getSequence());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
}
