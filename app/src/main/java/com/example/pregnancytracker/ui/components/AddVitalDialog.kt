package com.example.pregnancytracker.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.pregnancytracker.data.local.entity.VitalsEntity

@Composable
fun AddVitalsDialog(
    onDismiss: () -> Unit,
    onSubmit: (VitalsEntity) -> Unit
) {
    var sys by remember { mutableStateOf("") }
    var dia by remember { mutableStateOf("") }
    var hr by remember { mutableStateOf("") }
    var weight by remember { mutableStateOf("") }
    var kicks by remember { mutableStateOf("") }

    AlertDialog(
        onDismissRequest = onDismiss,
        confirmButton = {},

        title = {
            Text(text = "Add Vitals")
        },

        text = {
            Column(
                modifier = Modifier.padding(8.dp)
            ) {

                OutlinedTextField(
                    value = sys,
                    onValueChange = { sys = it },
                    label = { Text("Sys BP") },
                    modifier = Modifier.fillMaxWidth()
                )

                OutlinedTextField(
                    value = dia,
                    onValueChange = { dia = it },
                    label = { Text("Dia BP") },
                    modifier = Modifier.fillMaxWidth()
                )

                OutlinedTextField(
                    value = hr,
                    onValueChange = { hr = it },
                    label = { Text("Heart Rate") },
                    modifier = Modifier.fillMaxWidth()
                )

                OutlinedTextField(
                    value = weight,
                    onValueChange = { weight = it },
                    label = { Text("Weight (kg)") },
                    modifier = Modifier.fillMaxWidth()
                )

                OutlinedTextField(
                    value = kicks,
                    onValueChange = { kicks = it },
                    label = { Text("Baby Kicks") },
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(12.dp))

                Button(
                    onClick = {
                        onSubmit(
                            VitalsEntity(
                                sysBP = sys,
                                diaBP = dia,
                                heartRate = hr,
                                weight = weight,
                                babyKicks = kicks
                            )
                        )
                        onDismiss()
                    },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(text = "Submit")
                }
            }
        }
    )
}
