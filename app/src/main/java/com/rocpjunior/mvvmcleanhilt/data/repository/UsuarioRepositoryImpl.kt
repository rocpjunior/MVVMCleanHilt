package com.rocpjunior.mvvmcleanhilt.data.repository

import com.rocpjunior.mvvmcleanhilt.data.dto.toUsuario
import com.rocpjunior.mvvmcleanhilt.data.remote.DummyAPI
import com.rocpjunior.mvvmcleanhilt.domain.model.Usuario
import com.rocpjunior.mvvmcleanhilt.domain.repository.UsuarioRepository
import javax.inject.Inject

class UsuarioRepositoryImpl @Inject constructor(
    val dummyApi: DummyAPI
) : UsuarioRepository {
    override suspend fun usuarios(): List<Usuario> {

        try {
            val resposta = dummyApi.usuarios()
            if( resposta.isSuccessful && resposta.body() != null){
                val resultadoAPIDTO = resposta.body()
                val listaUsuarios = resultadoAPIDTO?.usuarioDTOS
                if( listaUsuarios != null ){
                    return listaUsuarios.map { it.toUsuario() }
                }
            }
        } catch (erroAoRecuperarUsuarios: Exception){
            erroAoRecuperarUsuarios.printStackTrace()
        }
        return emptyList()
    }
}