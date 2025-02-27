package com.example.com.data.persistence.models

import com.example.com.domain.models.Usuario
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID

class UsuarioDao(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<UsuarioDao>(UsuarioTable)

    var nombre by UsuarioTable.nombre
    var contrasena by UsuarioTable.contrasena
    var token by UsuarioTable.token

    fun toUsuario(): Usuario {
        return Usuario(id.value, nombre, contrasena, token)
    }
}