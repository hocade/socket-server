package com.hocade.socket.game.blindomok.adapter.`in`.rest

import com.hocade.socket.game.room.adapter.`in`.rest.dto.GameRoomDto
import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.messaging.simp.SimpMessagingTemplate
import org.springframework.stereotype.Controller

/**
 * @author jinwook.kim
 * @since 2024. 6. 1.
 */
@Controller
class BlindOmokController(
    private val template: SimpMessagingTemplate
) {

    // /pub/blind-omok/room 에 메세지가 오면 동작
    @MessageMapping(value = ["/blind-omok/room"])
    fun message(request: GameRoomDto.Request) {
        template.convertAndSend("/sub/blind-omok/room/" + request.roomId, request.message)
    }

}