package com.example.com.data.persistence.models

import org.jetbrains.exposed.dao.id.IntIdTable

object UsuarioTable : IntIdTable("Usuarios") {
    val nombre = varchar("nombre", 255).uniqueIndex()
    val contrasena = varchar("contrasena", 255)
    val token = varchar("token", 100).default("")
}