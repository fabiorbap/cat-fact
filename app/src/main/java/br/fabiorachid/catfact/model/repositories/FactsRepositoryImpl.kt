package br.fabiorachid.catfact.model.repositories

import br.fabiorachid.catfact.model.datasources.FactsLocalDataSource
import br.fabiorachid.catfact.model.datasources.FactsRemoteDataSource

class FactsRepositoryImpl(val factsLocalDataSource: FactsLocalDataSource,
factsRemoteDataSource: FactsRemoteDataSource): FactsRepository {
}