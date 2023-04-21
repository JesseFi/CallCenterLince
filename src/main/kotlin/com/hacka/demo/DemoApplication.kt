package com.hacka.demo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication(
	scanBasePackages = [
		"com.hacka.demo",
		"org.jetbrains.exposed.spring",
	],
)

class DemoApplication

fun main(args: Array<String>) {
	runApplication<DemoApplication>(*args)
}
