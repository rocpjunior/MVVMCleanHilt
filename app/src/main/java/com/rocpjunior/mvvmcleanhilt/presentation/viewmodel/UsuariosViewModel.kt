package com.rocpjunior.mvvmcleanhilt.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rocpjunior.mvvmcleanhilt.domain.model.Usuario
import com.rocpjunior.mvvmcleanhilt.domain.usecase.GetUsuarios
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UsuariosViewModel @Inject constructor(
    private val usuariosUseCase: GetUsuarios
) : ViewModel() {

    private val _usuarios = MutableLiveData<List<Usuario>>()

    val usuarios: LiveData<List<Usuario>>
        get() = _usuarios

    init {
        recuperarUsuarios()
    }

    fun recuperarUsuarios(){
        viewModelScope.launch {
            val listaUsuarios = usuariosUseCase()
            _usuarios.postValue(listaUsuarios)
        }
    }
}