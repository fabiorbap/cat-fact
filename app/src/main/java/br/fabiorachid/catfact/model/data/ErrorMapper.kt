package br.fabiorachid.catfact.model.data

import android.content.Context
import br.fabiorachid.catfact.model.data.app.error.Error
import br.fabiorachid.catfact.utils.ConnectionUtil
import retrofit2.HttpException

enum class ErrorType {
    NETWORK,
    NOT_FOUND,
    DEFAULT
}

fun mapError(error: Throwable, context: Context): ErrorType {
    return if (ConnectionUtil.isOnline(context))
        ErrorType.NETWORK
    else ErrorType.DEFAULT
    }


