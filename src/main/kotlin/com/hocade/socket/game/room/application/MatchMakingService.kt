package com.hocade.socket.game.room.application

import com.hocade.socket.game.room.application.dto.MatchMakingDto

/**
 * @author jinwook.kim
 * @since 2024. 7. 9.
 */
interface MatchMakingService {
    suspend fun quickMatch(dto: MatchMakingDto.Request)
}