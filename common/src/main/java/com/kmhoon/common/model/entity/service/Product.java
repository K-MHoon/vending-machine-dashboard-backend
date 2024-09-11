package com.kmhoon.common.model.entity.service;

import com.kmhoon.common.enums.product.ProductType;
import com.kmhoon.common.model.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Comment;

/**
 * 자판기에서 판매하는 물품
 */
@Entity
@Table(name = "tb_service_item")
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

    @Enumerated(EnumType.STRING)
    @Comment("물품타입")
    private ProductType type;
}
