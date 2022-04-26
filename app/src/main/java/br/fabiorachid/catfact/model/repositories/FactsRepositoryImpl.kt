package br.fabiorachid.catfact.model.repositories

import androidx.lifecycle.LiveData
import br.fabiorachid.catfact.model.data.local.FactLocalModel
import br.fabiorachid.catfact.model.data.remote.app.fact.FactAppModel
import br.fabiorachid.catfact.model.datasources.FactsLocalDataSource
import br.fabiorachid.catfact.model.datasources.FactsRemoteDataSource
import io.reactivex.Completable
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class FactsRepositoryImpl(
    private val factsLocalDataSource: FactsLocalDataSource,
    private val factsRemoteDataSource: FactsRemoteDataSource
) : FactsRepository {

    override fun getFact(): Single<FactAppModel> {
        return factsRemoteDataSource.getFact()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
    }

    override fun addFactToFavorites(fact: String): Completable {
        return factsLocalDataSource.addFactToFavorites(fact)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
    }

    override fun getFavoriteFacts(): Single<List<FactLocalModel>> {
        return factsLocalDataSource.getFavoriteFacts()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())

    }

    override fun deleteFactFromFavorites(factLocalModel: FactLocalModel): Completable {
        return factsLocalDataSource.deleteFactFromFavorites(factLocalModel)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
    }
}