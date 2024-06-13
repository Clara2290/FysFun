package com.example.fysfun20.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun Statistics(//her skal der komme en onclick save something fra local storage eskemplet
    navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
    ) {
        Column {
            Text(
                text = "Statistik",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(30.dp))

            Button(
                onClick = { /* Håndter klik her */ },
                modifier = Modifier
                    .padding(8.dp)
            ){
                Text("SPØRGESKEMAHISTORIK",
                    color = Color.Black)
            }

            Button(
                onClick = { /* Håndter klik her */ },
                modifier = Modifier
                    .padding(8.dp)
            ){
                Text("TRÆNINGSHISTORIK",
                    color = Color.Black)
            }
        }
    }
}