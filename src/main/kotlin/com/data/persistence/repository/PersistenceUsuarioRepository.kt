package com.example.com.data.persistence.repository

import com.example.com.data.persistence.models.UsuarioDao
import com.example.com.data.persistence.models.UsuarioTable

import com.example.com.data.persistence.models.suspendTransaction
import com.example.com.data.security.PasswordHash
import com.example.com.domain.models.Usuario
import com.example.com.domain.repository.UsuarioInterface

class PersistenceUsuarioRepository : UsuarioInterface {

    override suspend fun registrarUsuario(usuario: Usuario): Boolean {
        return suspendTransaction {
            val existe = UsuarioDao.find { UsuarioTable.nombre eq usuario.nombre }.firstOrNull()
            if (existe == null) {
                UsuarioDao.new {
                    nombre = usuario.nombre
                    contrasena = PasswordHash.hash(usuario.contrasena)
                    token = ""
                }
                true
            } else {
                false
            }
        }
    }

    //contraseña normal
    //override suspend fun login(nombre: String, contrasena: String): Usuario? {
    //    return suspendTransaction {
    //        val usuarioDao = UsuarioDao.find { UsuarioTable.nombre eq nombre }.firstOrNull()
    //        if (usuarioDao != null && usuarioDao.contrasena == contrasena) {
    //            usuarioDao.toUsuario()
    //        } else {
    //            null
    //        }
    //    }
    //}



    override suspend fun login(nombre: String, contrasena: String): Usuario? {
        return suspendTransaction {
            val usuarioDao = UsuarioDao.find { UsuarioTable.nombre eq nombre }.firstOrNull()

            if (usuarioDao != null) {

                val hashedPassword = if (contrasena.length != 64) {
                    PasswordHash.hash(contrasena)
                } else {
                    contrasena
                }

                println("Contrasena enviada (sin hash): $contrasena")
                println("Contrasena enviada (con hash): $hashedPassword")
                println("Contrasena almacenada en DB: ${usuarioDao.contrasena}")

                val isPasswordValid = hashedPassword == usuarioDao.contrasena

                println("Password es válido: $isPasswordValid")

                if (isPasswordValid) {
                    usuarioDao.toUsuario()
                } else {
                    null
                }
            } else {
                null
            }
        }
    }

}





