package com.kmhoon.common.repository.auth.map;

import com.kmhoon.common.model.entity.auth.map.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
}
