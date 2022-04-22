package br.fabiorachid.catfact.model.datasources

import br.fabiorachid.catfact.model.ApiInterface
import br.fabiorachid.catfact.model.data.app.fact.FactAppModel
import io.reactivex.Single

class FactsRemoteDataSourceImpl (val api: ApiInterface) : FactsRemoteDataSource {

    override fun getFact(): Single<FactAppModel> {
        return api.getFact()
            .map { mapFactToAppModel(it) }
    }

}