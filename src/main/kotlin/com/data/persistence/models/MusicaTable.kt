package com.example.com.data.persistence.models

import com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IdTable
import org.jetbrains.exposed.sql.Column

object MusicaTable : IdTable<String>("Musica") {
    // La columna nombre será la clave primaria
    var nombre = varchar("nombre", 100)

    val generoMusical = varchar("generoMusical", 100)
    val albums = varchar("albums", 100)
    val fechaNacimiento = varchar("fechaNacimiento", 100)
    val image = varchar("image", 255)


    override val id: Column<EntityID<String>> = nombre.entityId()

}
