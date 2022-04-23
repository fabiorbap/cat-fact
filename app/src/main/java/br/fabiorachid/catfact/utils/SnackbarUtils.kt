package br.fabiorachid.catfact.utils

import android.content.Context
import android.view.View
import br.fabiorachid.catfact.R
import com.google.android.material.snackbar.Snackbar

fun showSnackbar(context: Context, text: String, action: (() -> Unit)?, actionText: String? = context.getString(
    R.string.retry), view: View?) {
    val snackbar = view?.let { Snackbar.make(it, text, Snackbar.LENGTH_LONG) }
        if (action != null) snackbar?.setAction(actionText) {
            action.invoke()
        }
    snackbar?.show()
}