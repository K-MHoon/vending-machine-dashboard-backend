package com.kmhoon.common.model.entity.service.vendor;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Comment;
import org.hibernate.proxy.HibernateProxy;

import java.util.Objects;

/**
 * 공급업체
 */
@Entity
@Table(name = "tb_service_vendor")
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class Vendor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sequence;

    @Comment("회사명")
    private String name;

    @Comment("회사대표전화번호")
    private String phoneNumber;

    @Comment("회사위치")
    private String address;

    @Comment("사용여부")
    private Boolean isUse;

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        Vendor vendor = (Vendor) o;
        return getSequence() != null && Objects.equals(getSequence(), vendor.getSequence());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }

    public void updateAll(String name, String phoneNumber, String address, Boolean isUse) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.isUse = isUse;
    }
}
