package com.example.registroprestamos.utils

sealed class Screen (val route : String){

    object PersonaRegistroScreen : Screen("RegistroPersonas")
    object PrestamosRegistroScreen : Screen("RegistroPrestamos")
}