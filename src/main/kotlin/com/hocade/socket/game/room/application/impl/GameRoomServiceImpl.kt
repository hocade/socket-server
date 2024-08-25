package com.hocade.socket.game.room.application.impl

import com.hocade.socket.game.room.application.GameRoomService
import com.hocade.socket.game.room.application.dto.GameRoomDto
import com.hocade.socket.game.room.domain.GameRoom
import com.hocade.socket.game.room.persistence.GameRoomRepository
import org.springframework.stereotype.Service

/**
 * @author jinwook.kim
 * @since 2024. 7. 9.
 */
@Service
class GameRoomServiceImpl(
    private val gameRoomRepository: GameRoomRepository
) : GameRoomService {

    override fun create(dto: GameRoomDto.Create): GameRoom {
        val gameRoom = GameRoom.create(dto.gameType, dto.gameRoomType)
        return gameRoomRepository.save(gameRoom)
    }
}