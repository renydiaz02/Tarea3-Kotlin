package com.example.registroprestamos.ui.registro.persona

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.registroprestamos.data.repositorios.PersonaRepository
import com.example.registroprestamos.model.Personas
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PersonaViewModel @Inject constructor(
    val  personaRepository: PersonaRepository
) : ViewModel() {
    var nombres by mutableStateOf("")
    var email by mutableStateOf("")

    var balance by mutableStateOf(0.00)

    var personas = personaRepository.getList()
    private set

    fun Guardar(){
        viewModelScope.launch{
            personaRepository.insertar(
                Personas(
                    nombres = nombres,
                    email = email,
                    balance = balance.toFloat()
                )
            )
        }
    }
}