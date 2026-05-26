package com.rocpjunior.mvvmcleanhilt.domain.usecase

import com.rocpjunior.mvvmcleanhilt.domain.model.Usuario
import com.rocpjunior.mvvmcleanhilt.domain.repository.UsuarioRepository
import javax.inject.Inject

class GetUsuarios @Inject constructor(
    private val usuarioRepository: UsuarioRepository
) {

    suspend operator fun invoke(): List<Usuario>{
        return try {
            usuarioRepository.usuarios()

        } catch (erroUsuarios: Exception){
            erroUsuarios.printStackTrace()
            emptyList()
        }
    }
}