package br.fabiorachid.catfact.model.repositories

import br.fabiorachid.catfact.model.data.app.fact.FactAppModel
import io.reactivex.Single

interface FactsRepository {

    fun getFact(): Single<FactAppModel>

}