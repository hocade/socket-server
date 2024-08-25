package com.hocade.socket.common.properties

import org.springframework.boot.context.properties.ConfigurationProperties

/**
 * @author jinwook.kim
 * @since 2024. 7. 9.
 */
@ConfigurationProperties(prefix = "spring.redis")
class RedisProperties(
    val host: String,
    val port: Int,
)