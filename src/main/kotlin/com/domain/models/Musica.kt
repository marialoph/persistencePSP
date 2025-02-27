package com.example.com.domain.models

import kotlinx.serialization.Serializable

@Serializable
data class Musica(
    var nombre: String,
    var generoMusical: String,
    var albums: String,
    var fechaNacimiento: String,
    var image: String? = null

)