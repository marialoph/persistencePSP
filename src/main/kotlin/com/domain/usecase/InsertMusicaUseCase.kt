package com.example.com.domain.usecase

import com.example.com.domain.models.Musica
import com.example.com.domain.repository.MusicaInterface

class InsertMusicaUseCase(val repository: MusicaInterface) {
    var musica: Musica? = null

    suspend operator fun invoke(): Boolean {
        return if (musica == null) {
            false
        } else {
            repository.postMusica(musica!!)
        }
    }
}
