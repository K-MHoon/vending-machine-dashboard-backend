package com.kmhoon.common.model.entity.auth.user;

import com.kmhoon.common.model.entity.auth.map.UserRole;
import com.kmhoon.common.model.entity.service.group.ManagerGroup;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Comment;
import org.hibernate.type.NumericBooleanConverter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_auth_user")
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sequence;

    @Column(nullable = false, updatable = false)
    @Comment("이메일")
    private String email;

    @Column(nullable = false)
    @Comment("비밀번호")
    private String password;

    @Column(nullable = false)
    @Comment("이름")
    private String name;

    @Convert(converter = NumericBooleanConverter.class)
    @Column(nullable = false)
    @Builder.Default
    @Comment("사용여부")
    private Boolean isUse = Boolean.TRUE;

    @Builder.Default
    @Comment("비밀번호틀린횟수")
    private Long passwordWrongCount = 0L;

    @Column(nullable = false)
    @Builder.Default
    @Comment("잠김여부")
    private Boolean isLock = Boolean.FALSE;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "group_seq")
    private ManagerGroup managerGroup;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    @Builder.Default
    private List<UserRole> userRoleList = new ArrayList<>();
}
