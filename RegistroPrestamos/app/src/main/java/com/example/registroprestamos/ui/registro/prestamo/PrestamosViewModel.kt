package com.example.registroprestamos.ui.registro.prestamo

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.registroprestamos.data.repositorios.PersonaRepository
import com.example.registroprestamos.data.repositorios.PrestamosRepository
import com.example.registroprestamos.model.Personas
import com.example.registroprestamos.model.Prestamos
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.util.*
import javax.inject.Inject

@HiltViewModel
class PrestamosViewModel @Inject constructor(
    val prestamosRepository: PrestamosRepository
) : ViewModel() {

    var datePicked1 : String? by mutableStateOf(null)

    val updatedDate1 = { date : Long? ->
        datePicked1 = date?.toString()?:""
    }

    var datePicked2 : String? by mutableStateOf(null)

    val updatedDate2 = { date : Long? ->
        datePicked2 = date?.toString()?:""
    }

    var concepto by mutableStateOf("")
    var persona by mutableStateOf(0)
    var monto by mutableStateOf(0.00)
    var balance by mutableStateOf(0.00)

    var prestamos = prestamosRepository.getList()
        private set

    fun Guardar() {
        viewModelScope.launch {
            prestamosRepository.insertar(
                Prestamos(
                    fecha = updatedDate1.toString(),
                    vence = updatedDate2.toString(),
                    personaid = persona,
                    concepto = concepto,
                    monto = monto.toFloat(),
                    balance = balance.toFloat()
                )
            )
        }
    }


}