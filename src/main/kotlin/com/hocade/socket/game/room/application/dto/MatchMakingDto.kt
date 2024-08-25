package com.hocade.socket.game.room.application.dto

import com.hocade.socket.game.domain.GameType
import com.hocade.socket.game.room.domain.GameRoomType

/**
 * @author jinwook.kim
 * @since 2024. 7. 9.
 */
sealed class MatchMakingDto {
    data class Request(
        val userId: Long,
        val gameType: GameType,
        val gameRoomType: GameRoomType
    ) : MatchMakingDto()
}