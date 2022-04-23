package br.fabiorachid.catfact.model.data.app.error

import br.fabiorachid.catfact.model.data.ErrorType
import retrofit2.HttpException

data class Error(var errorMessage: String? = null, var type: ErrorType?)