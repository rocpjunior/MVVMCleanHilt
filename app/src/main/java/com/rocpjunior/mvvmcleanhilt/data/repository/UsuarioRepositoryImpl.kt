package com.rocpjunior.mvvmcleanhilt.data.repository

import com.rocpjunior.mvvmcleanhilt.data.remote.DummyAPI
import com.rocpjunior.mvvmcleanhilt.domain.model.Usuario
import com.rocpjunior.mvvmcleanhilt.domain.repository.UsuarioRepository
import javax.inject.Inject

class UsuarioRepositoryImpl @Inject constructor(
    val dummyApi: DummyAPI
) : UsuarioRepository {
    override suspend fun usuarios(): List<Usuario> {
        return emptyList()
    }
}