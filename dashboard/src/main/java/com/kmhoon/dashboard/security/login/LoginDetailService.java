package com.kmhoon.dashboard.security.login;

import com.kmhoon.common.model.entity.auth.user.User;
import com.kmhoon.common.repository.auth.user.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class LoginDetailService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmailWithRoles(username.strip()).orElseThrow(() -> new EntityNotFoundException("해당하는 이메일이 존재하지 않습니다."));

        if(Boolean.FALSE.equals(user.getIsUse())) {
            throw new EntityNotFoundException("사용 중지된 사용자 입니다. 관리자에게 문의하십시오.");
        }

        if(Boolean.TRUE.equals(user.getIsLock())) {
            throw new EntityNotFoundException("잠긴 사용자 입니다. 관리자에게 문의하십시오.");
        }

        List<SimpleGrantedAuthority> authorityList = user.getUserRoleList().stream()
                .map(u -> new SimpleGrantedAuthority(u.getRole().getName()))
                .toList();

        return new UserInfo(user.getEmail(), user.getName(), user.getPassword(), authorityList);
    }


}
