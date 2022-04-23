package br.fabiorachid.catfact.utils

import android.content.Context
import android.view.View
import com.google.android.material.snackbar.Snackbar

fun showSnackbar(text: String, action: (() -> Unit)?, actionText: String? = "", view: View?) {
    val snackbar = view?.let { Snackbar.make(it, text, Snackbar.LENGTH_LONG) }
        if (action != null) snackbar?.setAction(actionText) {
            action.invoke()
        }
    snackbar?.show()
}