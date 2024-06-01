package com.hocade.socket

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication

@SpringBootApplication
@ConfigurationPropertiesScan
class SocketApplication

fun main(args: Array<String>) {
    runApplication<SocketApplication>(*args)
}
