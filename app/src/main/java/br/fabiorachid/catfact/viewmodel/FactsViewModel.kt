package br.fabiorachid.catfact.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import br.fabiorachid.catfact.model.data.local.FactLocalModel
import br.fabiorachid.catfact.model.data.remote.Response
import br.fabiorachid.catfact.model.data.remote.app.error.Error
import br.fabiorachid.catfact.model.data.remote.app.fact.FactAppModel
import br.fabiorachid.catfact.model.repositories.FactsRepository
import br.fabiorachid.catfact.utils.setError
import br.fabiorachid.catfact.utils.setLoading
import br.fabiorachid.catfact.utils.setSuccess

class FactsViewModel(val factsRepository: FactsRepository) : BaseViewModel() {

    private val _factMLD = MutableLiveData<Response<FactAppModel>>()
    val factLD: LiveData<Response<FactAppModel>> = _factMLD

    private val _favoriteFactsMLD = MutableLiveData<Response<List<FactLocalModel>>>()
    val favoriteFactsLD: LiveData<Response<List<FactLocalModel>>> = _favoriteFactsMLD

    private val _addFavoriteFactMLD = MutableLiveData<Response<Nothing>>()
    val addFavoriteFactMLD: LiveData<Response<Nothing>> = _addFavoriteFactMLD

    fun getFact() {
        addDisposable(factsRepository.getFact()
            .doOnSubscribe { _factMLD.setLoading() }
            .subscribe(
                { _factMLD.setSuccess(it) },
                { _factMLD.setError(Error()) }
            )
        )
    }

    fun addFactToFavorites(fact: String) {
        addDisposable(factsRepository.addFactToFavorites(fact)
            .subscribe({
                    _addFavoriteFactMLD.setSuccess()
            }, {
                _addFavoriteFactMLD.setError()
            }))
    }

    fun getFavoriteFacts() {
        addDisposable(factsRepository.getFavoriteFacts()
            .subscribe({
                _favoriteFactsMLD.setSuccess(it)
            }, {
                _favoriteFactsMLD.setError()
            }))
    }
}