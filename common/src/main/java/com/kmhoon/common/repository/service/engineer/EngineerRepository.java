package com.kmhoon.common.repository.service.engineer;

import com.kmhoon.common.model.entity.service.engineer.Engineer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EngineerRepository extends JpaRepository<Engineer, Long> {
}
