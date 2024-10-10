package com.kmhoon.common.model.entity.service;

import com.kmhoon.common.enums.product.ProductType;
import com.kmhoon.common.model.entity.BaseEntity;
import com.kmhoon.common.model.entity.service.vendor.Vendor;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Comment;

/**
 * 자판기에서 판매하는 물품
 */
@Entity
@Table(name = "tb_service_product")
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class Product extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sequence;

    @Comment("물품코드")
    private String code;

    @Comment("물품명")
    private String name;

    @Comment("물품설명")
    private String description;

    @Comment("도매가")
    private long wholesalePrice;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vendor_seq")
    private Vendor vendor;

    @Enumerated(EnumType.STRING)
    @Comment("물품타입")
    private ProductType type;
}
