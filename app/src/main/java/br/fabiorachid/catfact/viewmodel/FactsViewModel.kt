package br.fabiorachid.catfact.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.fabiorachid.catfact.model.data.Response
import br.fabiorachid.catfact.model.data.app.fact.FactAppModel
import br.fabiorachid.catfact.model.repositories.FactsRepository
import br.fabiorachid.catfact.utils.setError
import br.fabiorachid.catfact.utils.setSuccess

class FactsViewModel (val factsRepository: FactsRepository): ViewModel() {

    private val _factMLD = MutableLiveData<Response<FactAppModel>>()
    val factLD: LiveData<Response<FactAppModel>> = _factMLD

    fun getFact() {
        factsRepository.getFact()
            .subscribe(
            {_factMLD.setSuccess(it) }, {
            })
    }
}