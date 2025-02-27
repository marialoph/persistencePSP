package com.example.com.domain.usecase

import com.example.com.domain.repository.MusicaInterface

class DeleteMusicaUseCase(private val repository: MusicaInterface) {

    suspend operator fun invoke(name: String): Boolean {
        return repository.deleteMusica(name)
    }
}