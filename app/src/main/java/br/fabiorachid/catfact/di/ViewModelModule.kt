package br.fabiorachid.catfact.di

import androidx.lifecycle.SavedStateHandle
import br.fabiorachid.catfact.viewmodel.FactsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {

    viewModel { (handle: SavedStateHandle) -> FactsViewModel(get(), handle) }

}