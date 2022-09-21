package com.example.registroprestamos.ui.registro.prestamo

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.registroprestamos.ui.componentes.DatePicker

@Composable
fun PrestamosRegistroScreen(
    navHostController: NavHostController,
    viewModel: PrestamosViewModel = hiltViewModel()
){


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
    ) {
        DatePicker(viewModel.datePicked1, viewModel.updatedDate1)
    }
}