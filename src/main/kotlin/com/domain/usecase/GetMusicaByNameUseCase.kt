package com.example.com.domain.usecase

import com.example.com.domain.models.Musica
import com.example.com.domain.repository.MusicaInterface

class GetMusicaByNameUseCase(private val repository: MusicaInterface) {
    suspend operator fun invoke(name: String): List<Musica> {
        return repository.getMusicaByName(name)
    }
}
