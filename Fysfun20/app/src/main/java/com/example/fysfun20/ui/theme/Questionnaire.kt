package com.example.fysfun20.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.app.unusedapprestrictions.IUnusedAppRestrictionsBackportCallback.Default
import androidx.navigation.NavController
import com.example.fysfun20.data.PainMedicine
import com.example.fysfun20.data.PainQuality
import com.example.fysfun20.data.TrainingRecord
import kotlinx.datetime.Instant
import kotlinx.datetime.LocalDate
import kotlinx.datetime.toLocalDateTime
import kotlinx.datetime.Clock
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime

@Composable
fun Questionnaire(onSaveClicked: (TrainingRecord)->Unit,
    navController: NavController
) {
    var showMessage by remember { mutableStateOf(false) }
    var messageText by remember { mutableStateOf("") }
    val scrollState = rememberScrollState()
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)

    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(scrollState)
        ) {
            Text(
                text = "Spørgeskema",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(30.dp))

            var painQuality by remember { mutableStateOf(PainQuality.LOW) }
            var painMedicine by remember{ mutableStateOf(PainMedicine.NO) }

            Column {
                Text(text = "Hvordan er dine smerter fra 0-4?")
                Row {
                    for (qualityType in PainQuality.values()) {
                        Text(text = qualityType.level.toString()) // Brug .name for at få enumværdiens navn
                        RadioButton(
                            selected = painQuality == qualityType,
                            onClick = { painQuality = qualityType }
                        )
                    }
                }

                Spacer(modifier = Modifier.height(30.dp))

                Text(text = "Har du taget smertestillende i dag?")
                Row {
                    for (qualityType in PainMedicine.values()) {
                        Text(text = qualityType.label.toString())
                        RadioButton(selected = painMedicine==qualityType,
                            onClick = {painMedicine=qualityType})
                    }

                }

        }

            Button(
                onClick = {
                          val trainingRecord = TrainingRecord(
                              quality= painQuality,
                              date = Clock.System.now().toLocalDateTime(TimeZone.currentSystemDefault()).date,
                              painMedicine = painMedicine.name
                          )
                    onSaveClicked(trainingRecord)

                    showMessage = true
                    messageText = "Tak for din besvarelse!"

                    painQuality=PainQuality.LOW
                    painMedicine=PainMedicine.NO
                },
                modifier = Modifier
                    .padding(8.dp)
            ){
                Text("GEM SPØRGESKEMA",
                    color = Color.Black)
            }
            if (showMessage) {
                Text(
                    text = messageText,
                    color = Color.Black,
                    fontSize = 16.sp,
                    modifier = Modifier.padding(8.dp)
                )
            }

        }
    }
}