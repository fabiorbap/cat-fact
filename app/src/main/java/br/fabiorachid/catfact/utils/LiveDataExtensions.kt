package br.fabiorachid.catfact.utils

import androidx.lifecycle.MutableLiveData
import br.fabiorachid.catfact.model.data.remote.Response
import br.fabiorachid.catfact.model.data.remote.ResponseStatus
import br.fabiorachid.catfact.model.data.remote.app.error.Error

fun <T> MutableLiveData<Response<T>>.setSuccess(data: T? = null) =
    postValue(Response(ResponseStatus.SUCCESS, data))

fun <T> MutableLiveData<Response<T>>.setLoading() =
    postValue(Response(ResponseStatus.LOADING, value?.data))

fun <T> MutableLiveData<Response<T>>.setError(errorResponse: Error? = null) =
    postValue(Response(ResponseStatus.ERROR, value?.data, errorResponse))