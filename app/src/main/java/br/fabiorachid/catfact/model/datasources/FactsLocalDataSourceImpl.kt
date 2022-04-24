package br.fabiorachid.catfact.model.datasources

import androidx.lifecycle.LiveData
import br.fabiorachid.catfact.model.data.local.FactLocalModel
import br.fabiorachid.catfact.model.datasources.database.FactsDatabase
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers

class FactsLocalDataSourceImpl(private val factsDatabase: FactsDatabase) : FactsLocalDataSource {
    override fun addFactToFavorites(fact: String): Completable {
        return Completable.fromCallable {
            factsDatabase.factsDao.addFactToFavorites(FactLocalModel(fact = fact))
        }
    }

    override fun getFavoriteFacts(): Single<List<FactLocalModel>> {
        return factsDatabase.factsDao.getFavoriteFacts()
    }
}