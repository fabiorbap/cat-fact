package br.fabiorachid.catfact.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import br.fabiorachid.catfact.model.data.Response
import br.fabiorachid.catfact.model.data.app.fact.FactAppModel
import br.fabiorachid.catfact.model.repositories.FactsRepository
import br.fabiorachid.catfact.utils.setError
import br.fabiorachid.catfact.utils.setLoading
import br.fabiorachid.catfact.utils.setSuccess

class FactsViewModel(val factsRepository: FactsRepository) : BaseViewModel() {

    private val _factMLD = MutableLiveData<Response<FactAppModel>>()
    val factLD: LiveData<Response<FactAppModel>> = _factMLD

    fun getFact() {
        addDisposable(factsRepository.getFact()
            .doOnSubscribe { _factMLD.setLoading() }
            .subscribe(
                { _factMLD.setSuccess(it) },
                { _factMLD.setError(Error(it as Exception)) }
            )
        )
    }
}