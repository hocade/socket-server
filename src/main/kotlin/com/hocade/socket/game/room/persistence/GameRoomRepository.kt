package com.hocade.socket.game.room.persistence

import com.hocade.socket.game.room.domain.GameRoom
import org.springframework.data.jpa.repository.JpaRepository

/**
 * @author jinwook.kim
 * @since 2024. 7. 9.
 */
interface GameRoomRepository : JpaRepository<GameRoom, Long> {
}