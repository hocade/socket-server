package com.hocade.socket.common.config

import com.hocade.socket.common.domain.StompPrincipal
import org.springframework.http.server.ServerHttpRequest
import org.springframework.stereotype.Component
import org.springframework.web.socket.WebSocketHandler
import org.springframework.web.socket.server.support.DefaultHandshakeHandler
import java.security.Principal
import java.time.LocalDateTime
import java.util.*

/**
 * @author jinwook.kim
 * @since 2024. 7. 1.
 */
@Component
class StompHandshakeHandler(

) : DefaultHandshakeHandler() {

    override fun determineUser(
        request: ServerHttpRequest,
        wsHandler: WebSocketHandler,
        attributes: MutableMap<String, Any>
    ): Principal? {
        return StompPrincipal(UUID.randomUUID().toString(), LocalDateTime.now())
    }

}