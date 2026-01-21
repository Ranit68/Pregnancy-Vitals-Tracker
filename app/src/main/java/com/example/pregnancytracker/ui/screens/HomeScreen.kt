package com.example.pregnancytracker.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pregnancytracker.ui.components.AddVitalsDialog
import com.example.pregnancytracker.ui.components.VitalsCard
import com.example.pregnancytracker.viewModel.VitalsViewModel

@Composable
fun HomeScreen(viewModel: VitalsViewModel) {

    val vitals by viewModel.vitals.collectAsState()
    var showDialog by remember { mutableStateOf(false) }

    val headerColor = Color(0xFFD1B3FF)
    val fabColor = Color(0xFF9C4FCC)

    Scaffold(
        topBar = {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp)
                    .background(headerColor),
                contentAlignment = Alignment.CenterStart
            ) {
                Text(
                    text = "Track My Pregnancy",
                    modifier = Modifier.padding(start = 16.dp),
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF4A0072)
                )
            }
        },

        floatingActionButton = {
            FloatingActionButton(
                onClick = { showDialog = true },
                containerColor = fabColor
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Add",
                    tint = Color.White
                )
            }
        }
    ) { paddingValues ->

        LazyColumn(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize(),
            contentPadding = PaddingValues(12.dp)
        ) {
            items(vitals) { vital ->
                VitalsCard(vital)
            }
        }
    }

    if (showDialog) {
        AddVitalsDialog(
            onDismiss = { showDialog = false },
            onSubmit = {
                viewModel.addVitals(it)
            }
        )
    }
}
