package com.example.com.domain.models

import kotlinx.serialization.Serializable

@Serializable
data class UpdateMusica (
    var nombre: String,
    var generoMusical: String? = null,
    var albums: String? = null,
    var fechaNacimiento: String? = null,
    var image: String ? = null

)