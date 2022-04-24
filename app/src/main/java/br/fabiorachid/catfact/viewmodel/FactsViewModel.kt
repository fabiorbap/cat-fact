package br.fabiorachid.catfact.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import br.fabiorachid.catfact.model.data.local.FactLocalModel
import br.fabiorachid.catfact.model.data.remote.Response
import br.fabiorachid.catfact.model.data.remote.app.error.Error
import br.fabiorachid.catfact.model.data.remote.app.fact.FactAppModel
import br.fabiorachid.catfact.model.repositories.FactsRepository
import br.fabiorachid.catfact.utils.SingleLiveEvent
import br.fabiorachid.catfact.utils.setError
import br.fabiorachid.catfact.utils.setLoading
import br.fabiorachid.catfact.utils.setSuccess

class FactsViewModel(
    private val factsRepository: FactsRepository,
    private val savedState: SavedStateHandle
) : BaseViewModel() {

    companion object {
        private const val HAS_FACT_BEEN_LOADED = "hasFactBeenLoaded"
    }

    private val _factMLD = MutableLiveData<Response<FactAppModel>>()
    val factLD: LiveData<Response<FactAppModel>> = _factMLD

    private val _favoriteFactsMLD = MutableLiveData<Response<List<FactLocalModel>>>()
    val favoriteFactsLD: LiveData<Response<List<FactLocalModel>>> = _favoriteFactsMLD

    private val _addFavoriteFactMLD = SingleLiveEvent<Response<Nothing>>()
    val addFavoriteFactLD: SingleLiveEvent<Response<Nothing>> = _addFavoriteFactMLD

    var hasFactBeenLoaded: Boolean = false
        set(value) {
            field = value
            // Simply update the savedState every time your saved property changes
            savedState.set(HAS_FACT_BEEN_LOADED, value)
        }
        get() {
            return savedState.get<Boolean>(HAS_FACT_BEEN_LOADED) ?: false
        }

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
            })
        )
    }

    fun getFavoriteFacts() {
        addDisposable(factsRepository.getFavoriteFacts()
            .subscribe({
                _favoriteFactsMLD.setSuccess(it)
            }, {
                _favoriteFactsMLD.setError()
            })
        )
    }
}