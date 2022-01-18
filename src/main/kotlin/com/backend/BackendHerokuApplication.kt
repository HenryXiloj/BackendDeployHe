package com.backend

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class BackendHerokuApplication

fun main(args: Array<String>) {
	runApplication<BackendHerokuApplication>(*args)
}
