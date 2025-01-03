package com.kmhoon.common.model.entity.service.vendingMachine;

import com.kmhoon.common.converter.VendingMachineTypeConverter;
import com.kmhoon.common.enums.vendingMachine.VendingMachineStatus;
import com.kmhoon.common.enums.vendingMachine.VendingMachineType;
import com.kmhoon.common.model.entity.BaseEntity;
import com.kmhoon.common.model.entity.auth.user.User;
import com.kmhoon.common.model.entity.service.delivery.DeliveryMan;
import com.kmhoon.common.model.entity.service.engineer.Engineer;
import com.kmhoon.common.model.entity.service.group.ManagerGroup;
import com.kmhoon.common.model.entity.service.vendor.Vendor;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Comment;
import org.hibernate.proxy.HibernateProxy;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
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
    private Double locationX;

    @Comment("Y좌표")
    private Double locationY;

    @Comment("주소")
    private String address;

    @Comment("사용여부")
    private Boolean isUse;

    @Comment("삭제여부")
    @Column(columnDefinition = "TINYINT(1) DEFAULT 0")
    private Boolean isDelete;

    @Enumerated(EnumType.STRING)
    @Comment("자판기상태")
    private VendingMachineStatus status;

    @Comment("자판기 관리자")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "manager_seq")
    private User manager;

    @Comment("자판기 소속 그룹")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "manager_group_seq")
    private ManagerGroup managerGroup;

    @Comment("자판기에 추가할 수 있는 최대 X개수")
    private Long sizeX;

    @Comment("자판기에 추가할 수 있는 최대 Y개수")
    private Long sizeY;

    @Convert(converter = VendingMachineTypeConverter.class)
    @Builder.Default
    private List<VendingMachineType> vendingMachineTypeList = new ArrayList<>();

    @Comment("자판기공급업체")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vendor_seq")
    private Vendor vendor;

    @Comment("자판기담당수리기사")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "engineer_seq")
    private Engineer engineer;

    @Comment("자판기물품배달기사")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "delivery_man_seq")
    private DeliveryMan deliveryMan;

    @Comment("다음점검일자")
    private LocalDate nextInspectionDate;

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

    public void updateAll(String code, String name, double locationX, double locationY, String address, Boolean isUse, VendingMachineStatus status, List<VendingMachineType> vendingMachineTypeList, Vendor vendor, Engineer engineer, DeliveryMan deliveryMan, LocalDate nextInspectionDate, Long sizeX, Long sizeY) {
        this.code = code;
        this.name = name;
        this.locationX = locationX;
        this.locationY = locationY;
        this.address = address;
        this.isUse = isUse;
        this.status = status;
        this.vendingMachineTypeList = vendingMachineTypeList;
        this.vendor = vendor;
        this.engineer = engineer;
        this.deliveryMan = deliveryMan;
        this.nextInspectionDate = nextInspectionDate;
        this.sizeX = sizeX;
        this.sizeY = sizeY;
    }

    public void delete() {
        this.isDelete = Boolean.TRUE;
    }
}
