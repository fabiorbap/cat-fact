package br.fabiorachid.catfact.model.datasources

import br.fabiorachid.catfact.model.data.api.fact.FactApiResponse
import br.fabiorachid.catfact.model.data.app.fact.FactAppModel

fun mapFactToAppModel(factApiResponse: FactApiResponse): FactAppModel {
    return FactAppModel().apply {
        this.fact = factApiResponse.fact
    }
}