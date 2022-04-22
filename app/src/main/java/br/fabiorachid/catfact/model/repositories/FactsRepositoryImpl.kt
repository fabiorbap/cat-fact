package br.fabiorachid.catfact.model.repositories

import br.fabiorachid.catfact.model.data.app.fact.FactAppModel
import br.fabiorachid.catfact.model.datasources.FactsLocalDataSource
import br.fabiorachid.catfact.model.datasources.FactsRemoteDataSource
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class FactsRepositoryImpl(private val factsLocalDataSource: FactsLocalDataSource,
                          private val factsRemoteDataSource: FactsRemoteDataSource): FactsRepository {

    override fun getFact(): Single<FactAppModel> {
        return factsRemoteDataSource.getFact()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
    }
}