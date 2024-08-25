package com.hocade.socket.game.room.application.impl

import com.hocade.socket.common.constant.RedisConstant
import com.hocade.socket.game.room.application.GameRoomService
import com.hocade.socket.game.room.application.MatchMakingService
import com.hocade.socket.game.room.application.dto.MatchMakingDto
import com.hocade.socket.game.room.application.mapper.GameRoomDtoMapper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import kotlinx.coroutines.withContext
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.messaging.simp.SimpMessagingTemplate
import org.springframework.stereotype.Service

/**
 * @author jinwook.kim
 * @since 2024. 7. 9.
 */
@Service
class MatchMakingServiceImpl(
    private val redisTemplate: RedisTemplate<String, Any>,
    private val messagingTemplate: SimpMessagingTemplate,
    private val gameRoomService: GameRoomService
) : MatchMakingService {
    private val mutex = Mutex()

    override suspend fun quickMatch(dto: MatchMakingDto.Request) {
        withContext(Dispatchers.IO) {
            mutex.withLock {
                val opponentId = redisTemplate.opsForList().leftPop(RedisConstant.waitingPlayerQueryKey)
                if (opponentId == null) {
                    redisTemplate.opsForList().rightPush(RedisConstant.waitingPlayerQueryKey, dto.userId.toString())
                } else {
                    val gameRoom = gameRoomService.create(GameRoomDtoMapper.instance.toDto(dto))
                    messagingTemplate.convertAndSend("/sub/blind-omok/match/", gameRoom.id!!)
                }
            }
        }
    }

}