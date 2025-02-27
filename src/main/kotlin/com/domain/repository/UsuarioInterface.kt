package com.example.com.domain.repository

import com.example.com.domain.models.Usuario

interface UsuarioInterface {
    suspend fun registrarUsuario(usuario: Usuario): Boolean
    suspend fun login(nombre: String, contrasena: String): Usuario?
}
