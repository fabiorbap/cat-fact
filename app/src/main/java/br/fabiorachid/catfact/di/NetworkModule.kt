package br.fabiorachid.catfact.di

import br.fabiorachid.catfact.model.datasources.FactsLocalDataSource
import br.fabiorachid.catfact.model.datasources.FactsLocalDataSourceImpl
import br.fabiorachid.catfact.model.datasources.FactsRemoteDataSource
import br.fabiorachid.catfact.model.datasources.FactsRemoteDataSourceImpl
import br.fabiorachid.catfact.model.repositories.FactsRepository
import br.fabiorachid.catfact.model.repositories.FactsRepositoryImpl
import org.koin.dsl.module

val networkModule = module {
    single<FactsRepository> { FactsRepositoryImpl(get(), get()) }

    single<FactsRemoteDataSource> { FactsRemoteDataSourceImpl() }

    single<FactsLocalDataSource> { FactsLocalDataSourceImpl() }
}