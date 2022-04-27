package br.fabiorachid.catfact

import android.app.Application
import br.fabiorachid.catfact.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin

class CatFactApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        initializeKoin()
    }

    private fun initializeKoin() {
        val listOfModules = listOf(
            modelModule,
            networkModule,
            viewModelModule,
            databaseModule
        )
        startKoin{
            androidLogger()
            androidContext(this@CatFactApplication)
            modules(listOfModules)
        }
    }

}