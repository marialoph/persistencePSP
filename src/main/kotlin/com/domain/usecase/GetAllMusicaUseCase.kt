package com.example.com.domain.usecase

import com.example.com.domain.models.Musica
import com.example.com.domain.repository.MusicaInterface

class GetAllMusicaUseCase(private val repository: MusicaInterface) {

    suspend operator fun invoke(): List<Musica> {
        return repository.getAllMusica()
    }
}
