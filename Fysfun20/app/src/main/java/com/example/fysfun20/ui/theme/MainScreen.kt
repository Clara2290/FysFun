package com.example.fysfun20.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.fysfun20.data.TrainingHistory
import com.example.fysfun20.data.TrainingRecord

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    navController: NavController,
    onSave:(TrainingRecord)->Unit,
    onClearData:()->Unit,
    trainingHistory: TrainingHistory
) {

    Column(
        modifier = Modifier
            .padding(8.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        Text(
            modifier = Modifier.padding(8.dp),
            text =
            """
                Velkommen tilbage 
                
                Sten Børge Hansen
               
            """.trimIndent(),
        )
        Button(
            onClick = { navController.navigate("questionnaire") },
            modifier = Modifier.padding(8.dp)
        ) {
            Text("MINE SYMPTOMER",
                color = Color.Black)
        }
        Button(
            onClick = { navController.navigate("training")},
            modifier = Modifier
                .padding(8.dp)
        ) {
            Text("START TRÆNING",
                color = Color.Black)
        }


    }

}