package br.fabiorachid.catfact.di

import br.fabiorachid.catfact.viewmodel.FactsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {

    viewModel { FactsViewModel(get()) }

}