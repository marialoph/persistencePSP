package com.example.com.data.persistence.models

import org.jetbrains.exposed.dao.Entity
import org.jetbrains.exposed.dao.EntityClass
import org.jetbrains.exposed.dao.id.EntityID

class MusicaDao(id: EntityID<String>) : Entity<String>(id) {
    companion object : EntityClass<String, MusicaDao>(MusicaTable)

    var nombre by MusicaTable.nombre
    var generoMusical by MusicaTable.generoMusical
    var albums by MusicaTable.albums
    var fechaNacimiento by MusicaTable.fechaNacimiento
    var image by MusicaTable.image

}