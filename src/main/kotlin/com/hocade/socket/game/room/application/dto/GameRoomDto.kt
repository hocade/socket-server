package com.hocade.socket.game.room.application.dto

import com.hocade.socket.game.domain.GameType
import com.hocade.socket.game.room.domain.GameRoomType

/**
 * @author jinwook.kim
 * @since 2024. 6. 1.
 */
sealed class GameRoomDto {
    data class Create(
        val gameType: GameType,
        val gameRoomType: GameRoomType
    ) : GameRoomDto()

    data class Response(
        val roomId: String,
        val message: String
    ) : GameRoomDto()

}