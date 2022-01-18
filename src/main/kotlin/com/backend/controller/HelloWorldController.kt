package com.backend.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloWorldController {

    @GetMapping("/hello")
    fun hello(): String {
        return "Hello World"
    }

    @GetMapping("/hello/{name}")
    fun hello(@PathVariable name: String): String {
        return "Hello $name"
    }
}