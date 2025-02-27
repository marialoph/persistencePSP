package com.example.com.domain.usecase

import com.example.com.domain.models.Usuario
import com.example.com.domain.repository.UsuarioInterface

class LoginUseCase (private val repository : UsuarioInterface){
    suspend fun execute(nombre: String, contrasena: String): Usuario? {
        return repository.login(nombre, contrasena)
    }

}