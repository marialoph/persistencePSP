package com.example

import com.example.com.data.persistence.repository.PersistenceMusicaRepository
import com.example.com.domain.models.Musica
import com.example.com.domain.models.UpdateMusica
import com.example.com.domain.usecase.DeleteMusicaUseCase
import com.example.com.domain.usecase.ProviderUseCase
import com.example.com.domain.usecase.ProviderUseCase.logger
import io.ktor.http.*
import io.ktor.serialization.*
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.application.*
import io.ktor.server.http.content.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    routing {
        get("/") {
            call.respondText("Hello World!")
        }

        // Endpoint para obtener todas las músicas o filtrar por nombre
        get("/musica") {
            val musicaName = call.request.queryParameters["name"]
            logger.warn("El nombre de la música es $musicaName")
            if (musicaName != null) {
                val musica = ProviderUseCase.getMusicaByName(musicaName)
                if (musica == null) {
                    call.respond(HttpStatusCode.NotFound, "Música no encontrada")
                } else {
                    call.respond(musica)
                }
                return@get
            }
            val musicas = ProviderUseCase.getAllMusica()
            call.respond(musicas)
        }

        // Endpoint para insertar música
        post("/musica") {
            try {
                val musica = call.receive<Musica>()
                val res = ProviderUseCase.insertMusica(musica)
                if (!res) {
                    call.respond(HttpStatusCode.Conflict, "La música no pudo insertarse. Puede que ya exista")
                    return@post
                }
                call.respond(HttpStatusCode.Created, "Se ha insertado correctamente: ${musica.nombre}")
            } catch (e: Exception) {
                call.respond(HttpStatusCode.BadRequest, "Error en los datos. Probablemente falten.")
            }
        }

        // Endpoint para actualizar música
        patch("/musica/{musicaName}") {
            try {
                val name = call.parameters["musicaName"]
                if (name == null || name.isBlank()) {
                    call.respond(HttpStatusCode.BadRequest, "Debes identificar el nombre de la música")
                    return@patch
                }

                val updateMusica = call.receive<UpdateMusica>()
                val res = ProviderUseCase.updateMusica(updateMusica, name)
                if (!res) {
                    call.respond(HttpStatusCode.NotFound, "La música con el nombre '$name' no pudo modificarse. Puede que no exista.")
                    return@patch
                }

                call.respond(HttpStatusCode.OK, "Se ha actualizado correctamente: $name")

            } catch (e: IllegalStateException) {
                call.respond(HttpStatusCode.BadRequest, "Error en el formato de los datos o lectura del cuerpo.")
            } catch (e: JsonConvertException) {
                call.respond(HttpStatusCode.BadRequest, "Error en el formato del JSON.")
            } catch (e: Exception) {
                call.respond(HttpStatusCode.InternalServerError, "Error inesperado: ${e.message}")
            }
        }


        // Endpoint para eliminar música por nombre
        delete("/musica/{musicaName}") {
            val name = call.parameters["musicaName"]

            if (name != null) {
                try {
                    val decodedName = java.net.URLDecoder.decode(name, "UTF-8")
                    val res = ProviderUseCase.deleteMusica(decodedName)
                    if (!res) {
                        call.respond(HttpStatusCode.NotFound, "Música no encontrada para borrar")
                    } else {
                        call.respond(HttpStatusCode.OK, "La música '$decodedName' ha sido eliminada exitosamente")
                    }
                } catch (e: Exception) {
                    call.respond(HttpStatusCode.InternalServerError, "Error al intentar eliminar la música")
                }
            } else {
                call.respond(HttpStatusCode.BadRequest, "Debes identificar la música")
            }
        }


        // Static plugin. Try to access `/static/index.html`
        staticResources("/static", "static")
    }
}
