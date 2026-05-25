package com.rocpjunior.mvvmcleanhilt.data.remote

import com.rocpjunior.mvvmcleanhilt.data.dto.ResultadoAPIDTO
import retrofit2.Response
import retrofit2.http.GET

interface DummyAPI {

    @GET("users")
    suspend fun usuarios(): Response <ResultadoAPIDTO>
}