package com.example

import com.example.com.domain.models.Usuario
import com.example.com.domain.usecase.ProviderUseCase
import io.ktor.http.*
import io.ktor.serialization.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.usuarioRouting() {
    post("/auth") {
        try {
            val loginRequest = call.receive<Usuario>()
            val usuario = ProviderUseCase.login(loginRequest.nombre, loginRequest.contrasena)

            if (usuario != null) {
                call.respondText("Usuario con nombre ${loginRequest.nombre} logueado", status = HttpStatusCode.OK)
            } else {
                call.respondText("Credenciales incorrectas", status = HttpStatusCode.Unauthorized)
            }
        } catch (e: Exception) {
            call.respondText("Error en los datos", status = HttpStatusCode.BadRequest)
        }
    }

    post("/register") {
        try {
            val user = call.receive<Usuario>()
            val register = ProviderUseCase.register(user)

            if (register) {
                call.respondText("Se ha registrado correctamente con nombre = ${user.nombre}", status = HttpStatusCode.Created)
            } else {
                call.respondText("El usuario ya existe", status = HttpStatusCode.Conflict)
            }
        } catch (e: IllegalStateException) {
            call.respondText("Error en el formato de envío de datos o lectura del cuerpo.", status = HttpStatusCode.BadRequest)
        } catch (e: JsonConvertException) {
            call.respondText("Problemas en la conversión JSON", status = HttpStatusCode.BadRequest)
        } catch (e: Exception) {
            call.respondText("Error en el servidor: ${e.localizedMessage}", status = HttpStatusCode.InternalServerError)
        }
    }

}