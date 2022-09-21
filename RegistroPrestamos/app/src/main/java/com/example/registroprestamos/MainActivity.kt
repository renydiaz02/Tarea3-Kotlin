package com.example.registroprestamos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.registroprestamos.ui.registro.persona.PersonaRegistroScreen
import com.example.registroprestamos.ui.registro.prestamo.PrestamosRegistroScreen
import com.example.registroprestamos.ui.theme.RegistroPrestamosTheme
import com.example.registroprestamos.utils.Screen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RegistroPrestamosTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MyApp()
                }
            }
        }
    }
}

@Composable
fun MyApp() {
    val navHostController = rememberNavController()

    NavHost(navController = navHostController, startDestination = Screen.PrestamosRegistroScreen.route){
        composable(Screen.PersonaRegistroScreen.route){
            PersonaRegistroScreen(navHostController = navHostController)
        }
        composable(Screen.PrestamosRegistroScreen.route){
            PrestamosRegistroScreen(navHostController = navHostController)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    RegistroPrestamosTheme {
        MyApp()
    }
}