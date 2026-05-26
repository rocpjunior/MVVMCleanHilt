package com.rocpjunior.mvvmcleanhilt.di

import com.rocpjunior.mvvmcleanhilt.data.remote.DummyAPI
import com.rocpjunior.mvvmcleanhilt.data.repository.UsuarioRepositoryImpl
import com.rocpjunior.mvvmcleanhilt.domain.repository.UsuarioRepository
import com.rocpjunior.mvvmcleanhilt.domain.usecase.GetUsuarios
import com.rocpjunior.mvvmcleanhilt.utilities.Constantes
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn (ViewModelComponent::class)
object AppModulo {

    @Provides
    fun proverRetrofit(): Retrofit{
        return Retrofit.Builder()
            .baseUrl(Constantes.URL_BASE)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    fun proverDummyAPI(retrofit: Retrofit): DummyAPI {
        return retrofit.create(DummyAPI::class.java)
    }

    @Provides
    fun proverUsuarioRepository(dummyAPI: DummyAPI): UsuarioRepository {
        return UsuarioRepositoryImpl(dummyAPI)
    }

    @Provides
    fun proverUsuarioUseCase(usuarioRepository: UsuarioRepository): GetUsuarios {
        return GetUsuarios(usuarioRepository)
    }
}