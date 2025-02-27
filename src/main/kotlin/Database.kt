package com.example

import io.ktor.server.application.*
import org.jetbrains.exposed.sql.Database

fun Application.configureDatabases(){
    val driver = environment.config.property("ktor.database.driver").getString()
    val url = environment.config.property("ktor.database.url").getString()
    val username = environment.config.property("ktor.database.username").getString()
    val password = environment.config.property("ktor.database.password").getString()

    try {
        Database.connect(
            url = url,
            driver = driver,
            user = username,
            password = password
        )
        log.info ("He establecido bien la conexión")
    }catch (e: Exception){
        log.error("Database connection failed: ${e.message}")
    }


}