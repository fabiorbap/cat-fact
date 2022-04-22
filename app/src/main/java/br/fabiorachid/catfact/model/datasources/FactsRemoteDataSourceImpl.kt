package br.fabiorachid.catfact.model.datasources

import br.fabiorachid.catfact.model.ApiInterface
import br.fabiorachid.catfact.model.data.FactApiResponse
import io.reactivex.Single

class FactsRemoteDataSourceImpl (val api: ApiInterface) : FactsRemoteDataSource {

    override fun getFact(): Single<FactApiResponse> {
        TODO("Not yet implemented")
    }
}