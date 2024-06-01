package com.hocade.socket.game.room.adapter.`in`.rest.dto

/**
 * @author jinwook.kim
 * @since 2024. 6. 1.
 */
sealed class GameRoomDto {
    data class Request(
        val roomId: String,
        val message: String
    ) : GameRoomDto()

}