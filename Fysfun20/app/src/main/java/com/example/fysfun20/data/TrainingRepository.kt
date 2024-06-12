package com.example.fysfun20.data

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

private const val KEY_HISTORY = "history"

class TrainingRepository(context: Context) {

    private val sharedPreferences = context.getSharedPreferences("prefs", Context.MODE_PRIVATE)
    private var changeListener: SharedPreferences.OnSharedPreferenceChangeListener? = null

    fun getTrainingHistory() = getTrainingHistory(sharedPreferences)

    private fun getTrainingHistory(sharedPreferences: SharedPreferences): TrainingHistory {
        val historyJsonString = sharedPreferences.getString(KEY_HISTORY, null)
        return if (historyJsonString == null) {
            TrainingHistory(emptyList())
        } else {
            Json.decodeFromString(historyJsonString)
        }
    }

    fun deleteData() {
        sharedPreferences.edit {
            remove(KEY_HISTORY)
        }
    }

    fun addTrainingRecord(trainingRecord: TrainingRecord) {
        val currentTrainingHistory = getTrainingHistory()

        val updatedTrainingRecordsList = currentTrainingHistory.trainingRecords + trainingRecord
        val updatedHistory = TrainingHistory(updatedTrainingRecordsList)

        val updatedHistoryJsonString = Json.encodeToString(updatedHistory)

        sharedPreferences.edit {
            putString(KEY_HISTORY, updatedHistoryJsonString)
        }
    }

    fun listenToHistoryChanges(onUpdate: (TrainingHistory) -> Unit) {
        changeListener = SharedPreferences.OnSharedPreferenceChangeListener { sharedPreferences, key ->
            onUpdate(getTrainingHistory(sharedPreferences))
        }
        sharedPreferences.registerOnSharedPreferenceChangeListener(changeListener)
    }

}