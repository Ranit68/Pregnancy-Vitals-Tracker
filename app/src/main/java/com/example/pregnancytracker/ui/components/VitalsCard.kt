package com.example.pregnancytracker.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pregnancytracker.data.local.entity.VitalsEntity
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@Composable
fun VitalsCard(vital: VitalsEntity) {

    val lightPurple = Color(0xFFF2D7FF)
    val darkPurple = Color(0xFF9C4FCC)

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 14.dp, vertical = 8.dp),
        shape = RoundedCornerShape(14.dp),
        colors = CardDefaults.cardColors(
            containerColor = lightPurple
        ),
        elevation = CardDefaults.cardElevation(6.dp)
    ) {

        Column {
            Row(
                modifier = Modifier
                    .padding(14.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
                    Text(
                        text = "❤️  ${vital.heartRate} bpm",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Medium
                    )

                    Text(
                        text = "⚖️  ${vital.weight} kg",
                        fontSize = 14.sp
                    )
                }

                Column(
                    horizontalAlignment = Alignment.End,
                    verticalArrangement = Arrangement.spacedBy(6.dp)
                ) {
                    Text(
                        text = "🩺  ${vital.sysBP}/${vital.diaBP} mmHg",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Medium
                    )

                    Text(
                        text = "👶  ${vital.babyKicks} kicks",
                        fontSize = 14.sp
                    )
                }
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(darkPurple)
                    .padding(vertical = 6.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = SimpleDateFormat(
                        "EEE, dd MMM yyyy hh:mm a",
                        Locale.getDefault()
                    ).format(Date(vital.timestamp)),
                    fontSize = 12.sp,
                    color = Color.White
                )
            }
        }
    }
}
