package com.rocpjunior.mvvmcleanhilt.domain.repository

import com.rocpjunior.mvvmcleanhilt.domain.model.Usuario

interface UsuarioRepository {
    suspend fun usuarios(): List<Usuario>
}