package br.fabiorachid.catfact.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.fabiorachid.catfact.model.repositories.FactsRepository

class FactsViewModel (val factsRepository: FactsRepository): ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is dashboard Fragment"
    }
    val text: LiveData<String> = _text
}