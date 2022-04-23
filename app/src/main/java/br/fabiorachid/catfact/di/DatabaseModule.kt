package br.fabiorachid.catfact.di

import androidx.room.Room
import br.fabiorachid.catfact.model.datasources.database.FactsDatabase
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val databaseModule = module {

    single {
        Room.databaseBuilder(androidApplication(), FactsDatabase::class.java, "FactDB")
            .fallbackToDestructiveMigration()
            .build()
    }

    single { get<FactsDatabase>().factsDao }

}