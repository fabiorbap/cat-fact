package br.fabiorachid.catfact.model.datasources

import br.fabiorachid.catfact.model.data.remote.api.FactApiResponse
import br.fabiorachid.catfact.model.data.remote.app.fact.FactAppModel

fun mapFactToAppModel(factApiResponse: FactApiResponse): FactAppModel {
    return FactAppModel().apply {
        this.fact = factApiResponse.fact
    }
}