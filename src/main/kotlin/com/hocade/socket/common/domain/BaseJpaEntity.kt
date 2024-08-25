package com.hocade.socket.common.domain

import jakarta.persistence.Column
import jakarta.persistence.EntityListeners
import jakarta.persistence.MappedSuperclass
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import org.springframework.format.annotation.DateTimeFormat
import java.time.LocalDateTime

/**
 * @author jinwook.kim
 * @since 2024. 7. 1.
 */
@MappedSuperclass
@EntityListeners(AuditingEntityListener::class)
abstract class BaseJpaEntity {
    @CreatedDate
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "CREATED_DATETIME", nullable = false, updatable = false)
    protected var createdAt: LocalDateTime = LocalDateTime.MIN

    @LastModifiedDate
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "UPDATED_DATETIME", nullable = false)
    protected var updatedAt: LocalDateTime = LocalDateTime.MIN

}