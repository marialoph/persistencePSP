package com.example.com.domain.usecase

import com.example.com.domain.models.UpdateMusica
import com.example.com.domain.repository.MusicaInterface

class UpdateMusicaUseCase(private val repository: MusicaInterface) {
    var updateMusica: UpdateMusica? = null
    var name: String? = null

    suspend operator fun invoke(): Boolean {
        val musica = updateMusica
        val musicaName = name

        if (musica != null && musicaName != null) {
            return repository.updateMusica(musica)
        }

        return false
    }
}