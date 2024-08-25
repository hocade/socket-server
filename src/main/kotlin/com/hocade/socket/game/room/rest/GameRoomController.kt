package com.hocade.socket.game.room.rest

import com.hocade.socket.game.room.application.MatchMakingService
import com.hocade.socket.game.room.application.dto.MatchMakingDto
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.stereotype.Controller

/**
 * @author jinwook.kim
 * @since 2024. 7. 9.
 */
@Controller
class GameRoomController(
    private val matchMakingService: MatchMakingService
) {

    // "/pub/blind-omok/match" 에 메세지가 오면 동작, 게임 퀵 매칭
    @OptIn(DelicateCoroutinesApi::class)
    @MessageMapping(value = ["/blind-omok/match"])
    fun message(request: MatchMakingDto.Request) {
        GlobalScope.launch {
            matchMakingService.quickMatch(request)
        }
    }
}