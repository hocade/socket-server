package com.hocade.socket.game.room.application

import com.hocade.socket.game.room.application.dto.GameRoomDto
import com.hocade.socket.game.room.domain.GameRoom

/**
 * @author jinwook.kim
 * @since 2024. 7. 9.
 */
interface GameRoomService {
    fun create(dto: GameRoomDto.Create): GameRoom
}