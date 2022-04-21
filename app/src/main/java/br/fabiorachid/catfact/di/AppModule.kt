package br.fabiorachid.catfact.di

import br.fabiorachid.catfact.model.datasources.FactsLocalDataSourceImpl
import br.fabiorachid.catfact.model.datasources.FactsRemoteDataSourceImpl
import br.fabiorachid.catfact.model.repositories.FactsRepositoryImpl
import br.fabiorachid.catfact.viewmodel.FactsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single { FactsRepositoryImpl(get(), get()) }

    single { FactsRemoteDataSourceImpl() }

    single { FactsLocalDataSourceImpl() }

    viewModel { FactsViewModel(get()) }

}