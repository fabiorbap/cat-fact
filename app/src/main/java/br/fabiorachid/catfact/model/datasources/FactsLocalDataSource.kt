package br.fabiorachid.catfact.model.datasources

import androidx.lifecycle.LiveData
import br.fabiorachid.catfact.model.data.local.FactLocalModel
import io.reactivex.Completable
import io.reactivex.Single

interface FactsLocalDataSource {

    fun addFactToFavorites(fact: String): Completable

    fun getFavoriteFacts(): Single<List<FactLocalModel>>

    fun deleteFactFromFavorites(factLocalModel: FactLocalModel): Completable

}