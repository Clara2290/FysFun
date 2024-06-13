package com.example.fysfun20.ui.theme

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.fysfun20.data.TrainingHistory
import com.example.fysfun20.data.TrainingRecord



@Composable
fun QuestionnaireHistory(list:List<TrainingRecord>, onClearDataClicked: () -> Unit, navController: NavController) {

    Column {
        Text(text = "Tidligere spørgeskema", style = MaterialTheme.typography.headlineLarge)
        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = onClearDataClicked) {
            Text(text = "Clear data")
        }
        Spacer(modifier = Modifier.height(8.dp))
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(list) { trainingRecord ->
                TrainingRecordCard(trainingRecord = trainingRecord)
            }
        }
    }
}

@Composable
fun TrainingRecordCard(trainingRecord: TrainingRecord) {
    Card {
        Column(modifier = Modifier.padding(8.dp)) {
            Text(text = "Quality: ${trainingRecord.quality.level}")
            Text(text = "Date: ${trainingRecord.date}")
            Text(text = "Pain Medicine: ${trainingRecord.painMedicine}")
        }
    }
}

