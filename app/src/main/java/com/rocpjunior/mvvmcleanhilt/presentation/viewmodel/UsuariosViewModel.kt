package com.rocpjunior.mvvmcleanhilt.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.rocpjunior.mvvmcleanhilt.domain.usecase.GetUsuarios
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class UsuariosViewModel @Inject constructor(
    private val usuariosUseCase: GetUsuarios
) : ViewModel() {
}