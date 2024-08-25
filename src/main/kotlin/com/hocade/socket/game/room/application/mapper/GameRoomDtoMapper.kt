package com.hocade.socket.game.room.application.mapper

import com.hocade.socket.game.room.application.dto.GameRoomDto
import com.hocade.socket.game.room.application.dto.MatchMakingDto
import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.mapstruct.factory.Mappers

/**
 * @author jinwook.kim
 * @since 2024. 7. 9.
 */
@Mapper
abstract class GameRoomDtoMapper {
    companion object {
        val instance: GameRoomDtoMapper = Mappers.getMapper(GameRoomDtoMapper::class.java)
    }

//    abstract fun toDto(gameType: GameType, gameRoomType: GameRoomType): GameRoomDto.Create

    abstract fun toDto(request: MatchMakingDto.Request): GameRoomDto.Create
}