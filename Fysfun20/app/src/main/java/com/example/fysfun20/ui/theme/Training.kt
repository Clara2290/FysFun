package com.example.fysfun20.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.app.unusedapprestrictions.IUnusedAppRestrictionsBackportCallback.Default
import androidx.navigation.NavController
import com.example.fysfun20.R
import com.example.fysfun20.data.PainQuality
import com.example.fysfun20.data.TrainingRecord
import kotlinx.datetime.LocalDate

@Composable
fun Training(
    navController: NavController,
) {
    val scrollState = rememberScrollState()

    // Mutable state for inputfelterne
    var rep by remember { mutableStateOf("") }
    var weight by remember { mutableStateOf("") }
    var execute by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
    ) {
        Text(
            text = "Træningsprogram",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )
            Box(
                modifier = Modifier
                    .width(width = 500.dp)
                    .height(height = 400.dp)
                    .background(color = Color.White)
            ) {
                Column(
                    modifier = Modifier
                        .padding(16.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.baekkenloft),
                        contentDescription = "Localized description",
                        modifier = Modifier.size(90.dp)
                    )
                    var rep by remember { mutableStateOf("") }
                    var weight by remember { mutableStateOf("") }
                    var execute by remember { mutableStateOf("") }
                    TextField(
                        value = rep,
                        onValueChange = { rep = it },
                        label = { Text("Antal af gentagelser") },
                        modifier = Modifier.padding(8.dp),
                        keyboardOptions = KeyboardOptions.Default.copy(
                            keyboardType = KeyboardType.Text
                        )
                    )
                    TextField(
                        value = weight,
                        onValueChange = { weight = it },
                        label = { Text("Belastning") },
                        modifier = Modifier.padding(8.dp),
                        keyboardOptions = KeyboardOptions.Default.copy(
                            keyboardType = KeyboardType.Text
                        )
                    )
                    TextField(
                        value = execute,
                        onValueChange = { execute = it },
                        label = { Text("Kunne ikke udføre øvelsen fordi...") },
                        modifier = Modifier.padding(8.dp),
                        keyboardOptions = KeyboardOptions.Default.copy(
                            keyboardType = KeyboardType.Text
                        )
                    )

                    Button(
                        onClick = { /* Håndter klik her */ },
                        modifier = Modifier
                            .padding(8.dp)
                    ) {
                        Text(
                            "Afslut øvelse 1",
                            color = Color.Black
                        )
                    }

                }
            }
        Spacer(modifier = Modifier.height(30.dp))
        Text(
            text = "Øvelse 2-Venepumpeøvelse",
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold
        )
        Box(
            modifier = Modifier
                .width(width = 500.dp)
                .height(height = 400.dp)
                .background(color = Color.White)
        ) {
            Column(
                modifier = Modifier
                    .padding(16.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.venepumpe),
                    contentDescription = "Localized description",
                    modifier = Modifier.size(90.dp)
                )
                var rep by remember { mutableStateOf("") }
                var weight by remember { mutableStateOf("") }
                var execute by remember { mutableStateOf("") }
                TextField(
                    value = rep,
                    onValueChange = { rep = it },
                    label = { Text("Antal af gentagelser") },
                    modifier = Modifier.padding(8.dp),
                    keyboardOptions = KeyboardOptions.Default.copy(
                        keyboardType = KeyboardType.Text
                    )
                )
                TextField(
                    value = weight,
                    onValueChange = { weight = it },
                    label = { Text("Belastning") },
                    modifier = Modifier.padding(8.dp),
                    keyboardOptions = KeyboardOptions.Default.copy(
                        keyboardType = KeyboardType.Text
                    )
                )
                TextField(
                    value = execute,
                    onValueChange = { execute = it },
                    label = { Text("Kunne ikke udføre øvelsen fordi...") },
                    modifier = Modifier.padding(8.dp),
                    keyboardOptions = KeyboardOptions.Default.copy(
                        keyboardType = KeyboardType.Text
                    )
                )

                Button(
                    onClick = { /* Håndter klik her */ },
                    modifier = Modifier
                        .padding(8.dp)
                ){
                    Text("Afslut øvelse 2",
                        color = Color.Black)
                }

            }

            Spacer(modifier = Modifier.height(30.dp))

        }
        }


    }
