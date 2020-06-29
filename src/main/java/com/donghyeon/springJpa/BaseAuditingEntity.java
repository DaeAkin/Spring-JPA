package com.donghyeon.springJpa;

import org.hibernate.annotations.Entity;
import org.springframework.context.event.EventListener;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseAuditingEntity {

    @CreatedDate
    protected LocalDateTime createdTime;


}
