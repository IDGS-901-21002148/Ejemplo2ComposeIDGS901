package com.example.ejemplo2composeidgs901

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

@Composable
fun SumaDosNumeros() {
    var num1 by remember { mutableStateOf("") }
    var num2 by remember { mutableStateOf("") }
    var resultado by remember { mutableStateOf("") }
    val operations = listOf("Suma", "Resta", "Multiplicación", "División")
    var selectedOperation by remember { mutableStateOf(operations[0]) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(
            value = num1,
            onValueChange = { num1 = it },
            label = { Text("Número 1") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        TextField(
            value = num2,
            onValueChange = { num2 = it },
            label = { Text("Número 2") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )



        Column(Modifier.selectableGroup()) {
            operations.forEach { text ->
                Row(
                    Modifier
                        .fillMaxWidth()
                        .selectable(
                            selected = (text == selectedOperation),
                            onClick = { selectedOperation = text },
                            role = Role.RadioButton
                        )
                        .padding(horizontal = 16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    RadioButton(
                        selected = (text == selectedOperation),
                        onClick = null
                    )
                    Text(
                        text = text,
                        modifier = Modifier.padding(start = 8.dp)
                    )
                }
            }
        }



        Button(onClick = {

            val n1 = num1.toDoubleOrNull()
            val n2 = num2.toDoubleOrNull()

            resultado = if (n1 != null && n2 != null) {
                when (selectedOperation) {
                    "Suma" -> "Resultado: ${n1 + n2}"
                    "Resta" -> "Resultado: ${n1 - n2}"
                    "Multiplicación" -> "Resultado: ${n1 * n2}"
                    "División" -> {
                        if (n2 != 0.0) {
                            "Resultado: ${n1 / n2}"
                        } else {
                            "No se puede dividir por cero"
                        }
                    }
                    else -> "Operación no erronea"
                }
            } else {
                "Ingrese números Validos papi"
            }
        }) {
            Text("Resultado")
        }
        Text(text = resultado)
    }
}