package com.example.com.data.persistence.repository

import com.example.com.data.persistence.models.MusicaDao
import com.example.com.data.persistence.models.MusicaTable
import com.example.com.data.persistence.models.suspendTransaction
import com.example.com.domain.mapping.toMusica
import com.example.com.domain.models.Musica
import com.example.com.domain.models.UpdateMusica
import com.example.com.domain.repository.MusicaInterface

class PersistenceMusicaRepository : MusicaInterface {

    // Obtener todas las músicas
    override suspend fun getAllMusica(): List<Musica> {
        return suspendTransaction {
            MusicaDao.all().map { it.toMusica() }
        }
    }

    // Obtener música por nombre
    override suspend fun getMusicaByName(name: String): List<Musica> {
        return suspendTransaction {
            MusicaDao.find { MusicaTable.nombre eq name }
                .map { it.toMusica() }
        }
    }

    // Crear música nueva
    override suspend fun postMusica(musica: Musica): Boolean {
        return suspendTransaction {
            val existingMusica = MusicaDao.find { MusicaTable.nombre eq musica.nombre }.firstOrNull()
            if (existingMusica == null) {
                MusicaDao.new(musica.nombre) {
                    generoMusical = musica.generoMusical
                    albums = musica.albums
                    fechaNacimiento = musica.fechaNacimiento
                    image = musica.image.toString()

                }
                true
            } else {
                false
            }
        }
    }

    // Actualizar música
    override suspend fun updateMusica(musica: UpdateMusica): Boolean {
        return suspendTransaction {
            val musicaDao = MusicaDao.find { MusicaTable.nombre eq musica.nombre }.firstOrNull()

            if (musicaDao != null) {
                musicaDao.apply {
                    musica.generoMusical?.let { generoMusical = it }
                    musica.albums?.let { albums = it }
                    musica.fechaNacimiento?.let { fechaNacimiento = it }
                    musica.image?.let { image = it }

                }
                true
            } else {
                false
            }
        }
    }

    // Eliminar música por nombre
    override suspend fun deleteMusica(nombre: String): Boolean {
        return suspendTransaction {
            val musicaDao = MusicaDao.find { MusicaTable.nombre eq nombre }.firstOrNull()
            if (musicaDao != null) {
                musicaDao.delete()
                true
            } else {
                false
            }
        }
    }
}
