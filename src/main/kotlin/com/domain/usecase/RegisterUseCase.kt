package com.example.com.domain.usecase

import com.example.com.domain.models.Usuario
import com.example.com.domain.repository.UsuarioInterface

class RegisterUseCase(private val repository: UsuarioInterface) {
    suspend fun execute(usuario: Usuario): Boolean {
        return repository.registrarUsuario(usuario)
    }
}