package com.example.registroprestamos.ui.registro.persona

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.registroprestamos.model.Personas
import com.example.registroprestamos.utils.Screen

@Composable
fun ConsultaPersonasScreen(
    navHostController: NavHostController,
    viewModel: PersonaViewModel = hiltViewModel()
) {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = "Consulta") })
        },
        floatingActionButton = {
            FloatingActionButton(onClick = { navHostController.navigate(Screen.PersonaRegistroScreen.route) }) {
                Icon(imageVector = Icons.Default.Add, contentDescription = null)
            }
        },
        floatingActionButtonPosition = FabPosition.End
    ) {
        Column(
            modifier = Modifier
                .padding(it)
                .padding(8.dp)
        ) {
            val lista = viewModel.personas.collectAsState(initial = emptyList())
            LazyColumn(modifier = Modifier.fillMaxWidth()) {
                items(lista.value) { persona ->
                    RowPersona(personas = persona)
                }
            }
        }
    }
}

@Composable
fun RowPersona(personas: Personas) {
    Column(modifier = Modifier.fillMaxSize()) {
        Row {

            Text(
                text = personas.nombres,
                style = MaterialTheme.typography.h6,
                modifier = Modifier.absolutePadding(0.dp, 0.dp, 6.dp, 0.dp)
            )
            Text(text = personas.balance.toString(), style = MaterialTheme.typography.h6)
        }

        Text(text = personas.email, style = MaterialTheme.typography.subtitle1)

    }
}