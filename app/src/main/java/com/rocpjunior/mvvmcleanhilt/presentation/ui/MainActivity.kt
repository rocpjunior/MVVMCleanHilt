package com.rocpjunior.mvvmcleanhilt.presentation.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.rocpjunior.mvvmcleanhilt.R
import com.rocpjunior.mvvmcleanhilt.databinding.ActivityMainBinding
import com.rocpjunior.mvvmcleanhilt.presentation.viewmodel.UsuariosViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    private lateinit var usuariosViewModel: UsuariosViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        usuariosViewModel = ViewModelProvider(this)[UsuariosViewModel::class.java]

        usuariosViewModel.usuarios.observe(this){ usuarios ->
            var resultado = ""
            usuarios.forEach { usuario ->
                val nome = usuario.nome
                val sobrenome = usuario.sobrenome
                val idade = usuario.idade
            resultado += "+) $nome - $sobrenome - $idade \n"
            }
            binding.textResultado.text = resultado
        }
    }
}