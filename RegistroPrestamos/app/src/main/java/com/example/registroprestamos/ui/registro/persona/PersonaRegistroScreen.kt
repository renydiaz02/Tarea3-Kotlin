package com.example.registroprestamos.ui.registro.persona

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Money
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.registroprestamos.utils.Validar
import org.intellij.lang.annotations.Pattern


@Composable
fun PersonaRegistroScreen(
    navHostController: NavHostController,
    viewModel: PersonaViewModel = hiltViewModel()
) {
    //INICIO DEL DISEîO

    var errornombre by remember {
        mutableStateOf(false)
    }
    var erroremail by remember {
        mutableStateOf(false)
    }
    var errorbalance by remember {
        mutableStateOf(false)
    }
    val contexto = LocalContext.current

    Column(modifier = Modifier.padding(8.dp)) {

        OutlinedTextField(
            value = viewModel.nombres,
            onValueChange = { viewModel.nombres = it },
            modifier = Modifier.fillMaxWidth(),
            label = {
                Text(text = "Nombre Completo")
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = null
                )
            },
            isError = errornombre
        )
        Validar(error = errornombre, text = "Ingrese su Nombre")

        OutlinedTextField(
            value = viewModel.email,
            onValueChange = { viewModel.email = it },
            modifier = Modifier.fillMaxWidth(),
            label = {
                Text(text = "Email")
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Email,
                    contentDescription = null
                )
            },
            isError = erroremail
        )
        Validar(error = erroremail, text = "Ingrese su Email")

        OutlinedTextField(
            value = viewModel.balance.toString(),
            onValueChange = { viewModel.balance = it.toDouble() },
            modifier = Modifier.fillMaxWidth(),
            label = {
                Text(text = "Balance")
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Money,
                    contentDescription = null
                )
            },
            isError = errorbalance,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        Validar(error = errorbalance, text = "Ingrese un Balance Valido")

        OutlinedButton(onClick = {

            errornombre = viewModel.nombres.isBlank()
            erroremail = viewModel.email.isBlank()
            errorbalance = viewModel.balance.toString().isBlank()

            if (!errornombre && !erroremail && !errorbalance) {
                if (isNumeric(viewModel.balance.toString()) == false)
                    Toast.makeText(
                        contexto,
                        "BALANCE NO VALIDO",
                        Toast.LENGTH_LONG
                    ).show()
            } else {
                if (viewModel.balance > 0) {
                    viewModel.Guardar()
                    Toast.makeText(
                        contexto,
                        "Guardado Correctamente",
                        Toast.LENGTH_LONG
                    ).show()
                } else {
                    Toast.makeText(
                        contexto,
                        "El Balance no puede estar en negativo",
                        Toast.LENGTH_LONG
                    ).show()
                }
            }

        }) {
            Text(text = "Guardar")
        }

    }
}

fun isNumeric(str: String): Boolean {
    return str.matches("-?\\d+(\\.\\d+)?".toRegex())
}

