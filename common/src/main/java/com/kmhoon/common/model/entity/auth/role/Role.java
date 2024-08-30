package com.kmhoon.common.model.entity.auth.role;

import com.kmhoon.common.model.entity.auth.map.RolePrivilege;
import com.kmhoon.common.model.entity.auth.map.UserRole;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Comment;
import org.hibernate.proxy.HibernateProxy;
import org.hibernate.type.NumericBooleanConverter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "tb_auth_role")
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sequence;

    @Comment("이름")
    private String name;

    @Convert(converter = NumericBooleanConverter.class)
    @Comment("사용여부")
    private Boolean isUse;

    @OneToMany(mappedBy = "role", fetch = FetchType.LAZY)
    @Builder.Default
    private List<UserRole> userRoleList = new ArrayList<>();

    @OneToMany(mappedBy = "role", fetch = FetchType.LAZY)
    @Builder.Default
    private List<RolePrivilege> rolePrivilegeList = new ArrayList<>();

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        Role role = (Role) o;
        return getSequence() != null && Objects.equals(getSequence(), role.getSequence());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
}
