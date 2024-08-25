package com.hocade.socket.common.domain

import java.security.Principal
import java.time.LocalDateTime

/**
 * @author jinwook.kim
 * @since 2024. 7. 1.
 */
class StompPrincipal(
    private val name: String,
    private val createdAt: LocalDateTime,
) : Principal {
    override fun getName(): String {
        return this.name
    }
}