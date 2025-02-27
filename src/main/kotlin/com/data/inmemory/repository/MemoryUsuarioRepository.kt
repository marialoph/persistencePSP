package com.example.com.data.inmemory.repository

import com.example.com.domain.models.Usuario
import com.example.com.domain.repository.UsuarioInterface

class MemoryUsuarioRepository : UsuarioInterface {
    private val usuarios = mutableListOf<Usuario>()

    override suspend fun registrarUsuario(usuario: Usuario): Boolean {
        if (usuarios.any { it.nombre == usuario.nombre }) return false
        usuarios.add(usuario)
        return true
    }

    override suspend fun login(nombre: String, contrasena: String): Usuario? {
        return usuarios.find { it.nombre == nombre && it.contrasena == contrasena }
    }
}
