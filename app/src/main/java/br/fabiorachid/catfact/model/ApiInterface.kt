package br.fabiorachid.catfact.model

import br.fabiorachid.catfact.model.data.api.fact.FactApiResponse
import io.reactivex.Single
import retrofit2.http.GET

interface ApiInterface {

    @GET("/fact")
    fun getFact(): Single<FactApiResponse>
}