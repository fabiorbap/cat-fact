package br.fabiorachid.catfact.model.datasources

import br.fabiorachid.catfact.model.data.remote.app.fact.FactAppModel
import io.reactivex.Single

interface FactsRemoteDataSource {

    fun getFact(): Single<FactAppModel>

}