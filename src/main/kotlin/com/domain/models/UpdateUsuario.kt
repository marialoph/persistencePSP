package com.example.com.domain.models

import kotlinx.serialization.Serializable

@Serializable
data class UpdateUsuario(
    val nombre: String,
    val contrasena: String
)