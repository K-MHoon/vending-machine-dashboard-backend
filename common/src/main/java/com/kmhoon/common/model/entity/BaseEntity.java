package com.kmhoon.common.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.hibernate.annotations.Comment;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter
@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
public class BaseEntity extends BaseTimeEntity {

    @Column(name = "created_by", updatable = false)
    @CreatedBy
    @Comment("생성자")
    private String createdBy;

    @Column(name = "modified_by")
    @LastModifiedBy
    @Comment("수정자")
    private String modifiedBy;
}
