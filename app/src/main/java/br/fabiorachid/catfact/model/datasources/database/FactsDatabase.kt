package br.fabiorachid.catfact.model.datasources.database

import androidx.room.Database
import androidx.room.RoomDatabase
import br.fabiorachid.catfact.model.data.local.FactDao
import br.fabiorachid.catfact.model.data.local.FactLocalModel

@Database(entities = [FactLocalModel::class], version = 1, exportSchema = false)
abstract class FactsDatabase: RoomDatabase() {
    abstract val factsDao: FactDao
}