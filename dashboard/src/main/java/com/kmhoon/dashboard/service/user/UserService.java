package com.kmhoon.dashboard.service.user;

import com.kmhoon.common.enums.auth.RoleType;
import com.kmhoon.common.model.dto.service.user.CreateUserRequest;
import com.kmhoon.common.model.entity.auth.map.UserRole;
import com.kmhoon.common.model.entity.auth.role.Role;
import com.kmhoon.common.model.entity.auth.user.User;
import com.kmhoon.common.repository.auth.map.UserRoleRepository;
import com.kmhoon.common.repository.auth.role.RoleRepository;
import com.kmhoon.common.repository.auth.user.UserRepository;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserRoleRepository userRoleRepository;

    @Transactional
    public void register(CreateUserRequest request) {
        if(userRepository.existsByEmail(request.getEmail())) {
            throw new EntityExistsException("User with email already exists");
        }

        User user = User.builder()
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .isUse(Boolean.TRUE)
                .name(request.getUsername())
                .isLock(Boolean.FALSE)
                .passwordWrongCount(0L)
                .build();

        User savedUser = userRepository.save(user);

        Role role = roleRepository.findByNameAndIsUseIsTrue(RoleType.USER).orElseThrow(EntityNotFoundException::new);

        UserRole userRole = UserRole.builder()
                .role(role)
                .user(savedUser)
                .build();

        userRoleRepository.save(userRole);
    }
}
