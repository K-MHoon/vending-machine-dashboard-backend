package com.kmhoon.common.model.entity.service.group;

import com.kmhoon.common.enums.group.GroupLevel;
import com.kmhoon.common.model.entity.auth.user.User;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Comment;
import org.hibernate.proxy.HibernateProxy;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 관리자 그룹
 */
@Entity
@Table(name = "tb_service_engineer")
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class ManagerGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sequence;

    @Comment("이름")
    private String name;

    @Comment("삭제여부")
    @Column(columnDefinition = "TINYINT(1) DEFAULT 0")
    private Boolean isDelete;

    @Comment("사용여부")
    private Boolean isUse;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "managerGroup")
    @Builder.Default
    private List<User> userList = new ArrayList<>();

    @Comment("그룹등급")
    @Enumerated(value = EnumType.STRING)
    private GroupLevel level;

    @Comment("서비스만료일자")
    //TODO 추후 배치처리
    private LocalDate expiredDate;

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        ManagerGroup that = (ManagerGroup) o;
        return getSequence() != null && Objects.equals(getSequence(), that.getSequence());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
}
