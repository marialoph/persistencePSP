package com.example.com.data.inmemory.repository

import com.example.com.data.inmemory.models.MusicaData
import com.example.com.domain.models.Musica
import com.example.com.domain.models.UpdateMusica
import com.example.com.domain.repository.MusicaInterface

class MemoryMusicaRepository : MusicaInterface {
    private val musicaList = MusicaData.listaMusica

    override suspend fun getAllMusica(): List<Musica> {
        return musicaList
    }

    override suspend fun getMusicaByName(name: String): List<Musica> {
        return musicaList.filter { it.nombre.equals(name, ignoreCase = true) }
    }

    override suspend fun postMusica(musica: Musica): Boolean {
        return if (musicaList.any { it.nombre.equals(musica.nombre, ignoreCase = true) }) {
            false
        } else {
            musicaList.add(musica)
            true
        }    }

    override suspend fun updateMusica(musica: UpdateMusica): Boolean {
        val index = musicaList.indexOfFirst { it.nombre.equals(musica.nombre, ignoreCase = true) }
        return if (index != -1) {
            musicaList[index] = Musica(
                musica.nombre,
                musica.generoMusical ?: musicaList[index].generoMusical,
                musica.albums ?: musicaList[index].albums,
                musica.fechaNacimiento ?: musicaList[index].fechaNacimiento,
                musica.image ?: musicaList[index].image,

            )
            true
        } else {
            false
        }
    }

    override suspend fun deleteMusica(nombre: String): Boolean {
        return musicaList.removeIf { it.nombre.equals(nombre, ignoreCase = true) }    }



}