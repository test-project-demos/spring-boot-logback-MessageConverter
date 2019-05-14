package com.example.logbackMessageConverter

import org.slf4j.LoggerFactory
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class LogbackMessageConverterApplication : CommandLineRunner {
    private val logger = LoggerFactory.getLogger(LogbackMessageConverterApplication::class.java)

    override fun run(vararg args: String?) {
        val student = Student("abc")
        logger.error("student: {}", student)
    }

}

fun main(args: Array<String>) {
    runApplication<LogbackMessageConverterApplication>(*args)
}
