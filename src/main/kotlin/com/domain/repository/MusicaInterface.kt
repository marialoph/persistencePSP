package com.example.com.domain.repository

import com.example.com.domain.models.Musica
import com.example.com.domain.models.UpdateMusica

interface MusicaInterface {
    suspend fun getAllMusica () : List <Musica>
    suspend fun getMusicaByName ( name : String) : List<Musica>
    suspend fun postMusica(musica: Musica) : Boolean

    suspend fun updateMusica(musica: UpdateMusica) : Boolean

    suspend fun deleteMusica(nombre : String) : Boolean


}