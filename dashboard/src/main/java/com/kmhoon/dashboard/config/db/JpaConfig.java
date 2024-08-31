package com.kmhoon.dashboard.config.db;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
@EnableJpaRepositories(basePackages = "com.kmhoon.common.repository")
@EntityScan(basePackages = "com.kmhoon.common.model.entity")
public class JpaConfig {

    @Bean
    public AuditorAware<String> auditorAware() {
        return new UserAuditorAware();
    }
}
