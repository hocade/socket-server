package com.hocade.socket.game.room.domain

import com.hocade.socket.common.domain.BaseJpaEntity
import com.hocade.socket.game.domain.GameType
import jakarta.persistence.*

/**
 * @author jinwook.kim
 * @since 2024. 7. 1.
 */
@Entity
@Table(name = "GAME_ROOM")
class GameRoom(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    var id: Long? = null,

    @Enumerated(EnumType.STRING)
    @Column(name = "GAME_TYPE")
    var gameType: GameType,

    @Enumerated(EnumType.STRING)
    @Column(name = "TYPE")
    var type: GameRoomType,

    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS")
    var status: GameRoomStatus = GameRoomStatus.WAITING
) : BaseJpaEntity() {

    companion object {
        fun create(gameType: GameType, gameRoomType: GameRoomType): GameRoom {
            return GameRoom(null, gameType, gameRoomType)
        }
    }
}