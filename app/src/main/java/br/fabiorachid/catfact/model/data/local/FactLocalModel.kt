package br.fabiorachid.catfact.model.data.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "factsTable")
data class FactLocalModel(
    @PrimaryKey(autoGenerate = true)
    var factId: Int = 0,
    @ColumnInfo(name = "fact")
    val fact: String,
)