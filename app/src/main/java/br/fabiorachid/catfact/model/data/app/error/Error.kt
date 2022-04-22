package br.fabiorachid.catfact.model.data.app.error

import retrofit2.HttpException

data class Error(var errorMessage: String? = null, var type: ErrorType?): Throwable()

enum class ErrorType {

}