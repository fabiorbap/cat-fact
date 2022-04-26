package br.fabiorachid.catfact.model.repositories

import androidx.lifecycle.LiveData
import br.fabiorachid.catfact.model.data.local.FactLocalModel
import br.fabiorachid.catfact.model.data.remote.app.fact.FactAppModel
import io.reactivex.Completable
import io.reactivex.Single

interface FactsRepository {

    fun getFact(): Single<FactAppModel>

    fun addFactToFavorites(fact: String): Completable

    fun getFavoriteFacts(): Single<List<FactLocalModel>>

    fun deleteFactFromFavorites(factLocalModel: FactLocalModel): Completable

}