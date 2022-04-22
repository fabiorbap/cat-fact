package br.fabiorachid.catfact.model.datasources

import br.fabiorachid.catfact.model.data.FactApiResponse
import io.reactivex.Single

interface FactsRemoteDataSource {

    fun getFact(): Single<FactApiResponse>

}