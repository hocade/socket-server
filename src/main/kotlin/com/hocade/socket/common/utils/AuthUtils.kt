package com.hocade.socket.common.utils

import org.springframework.security.core.Authentication
import org.springframework.security.core.context.SecurityContextHolder

/**
 * @author jinwook.kim
 * @since 2024. 7. 9.
 */
object AuthUtils {
    fun getAuth(): Authentication = SecurityContextHolder.getContext().authentication
    fun me(email: String) = getAuth().name == email
}