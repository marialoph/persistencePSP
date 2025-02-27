package com.example.com.domain.mapping


import com.example.com.data.persistence.models.MusicaDao
import com.example.com.domain.models.Musica
import com.example.com.domain.models.UpdateMusica

fun MusicaDao.toMusica(): Musica {
    return Musica(
        nombre = this.nombre,
        generoMusical = this.generoMusical,
        albums = this.albums,
        fechaNacimiento = this.fechaNacimiento,
        image = this.image,

    )
}

fun Musica.toUpdateMusica(): UpdateMusica {
    return UpdateMusica(
        nombre = this.nombre,
        generoMusical = this.generoMusical,
        albums = this.albums,
        fechaNacimiento = this.fechaNacimiento,
        image = this.image,

    )
}

fun UpdateMusica.toMusica(): Musica {
    return Musica(
        nombre = this.nombre,
        generoMusical = this.generoMusical ?: "",
        albums = this.albums ?: "",
        fechaNacimiento = this.fechaNacimiento ?: "",
        image = this.image ?: "",

    )
}

