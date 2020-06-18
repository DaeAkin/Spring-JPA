package com.donghyeon.springJpa;

import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@MappedSuperclass
public class BaseAuditingEntity {
    protected LocalDateTime createdTime;
}
