package com.kmhoon.common.model.entity.service;

import com.kmhoon.common.model.entity.BaseEntity;
import com.kmhoon.common.model.entity.auth.user.User;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Comment;
import org.hibernate.proxy.HibernateProxy;

import java.util.Objects;

/**
 * 자판기 엔티티
 */
@Entity
@Table(name = "tb_service_vending_machine")
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class VendingMachine extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sequence;

    @Comment("자판기코드")
    @Column(unique = true)
    private String code;

    @Comment("이름")
    private String name;

    @Comment("X좌표")
    private double locationX;

    @Comment("Y좌표")
    private double locationY;

    @Comment("주소")
    private String address;

    @Comment("자판기 관리자")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "manager_seq")
    private User manager;

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        VendingMachine that = (VendingMachine) o;
        return getSequence() != null && Objects.equals(getSequence(), that.getSequence());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
}
