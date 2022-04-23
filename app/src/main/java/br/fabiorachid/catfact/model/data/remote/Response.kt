package br.fabiorachid.catfact.model.data.remote

import br.fabiorachid.catfact.model.data.remote.app.error.Error

sealed class ResponseStatus {
    object LOADING : ResponseStatus()
    object SUCCESS : ResponseStatus()
    object ERROR : ResponseStatus()
}

data class Response<out T> constructor(
    val status: ResponseStatus,
    val data: T? = null,
    val error: Error? = null
)