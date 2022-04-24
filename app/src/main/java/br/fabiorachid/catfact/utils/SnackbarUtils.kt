package br.fabiorachid.catfact.utils

import android.content.Context
import android.view.View
import br.fabiorachid.catfact.R
import com.google.android.material.snackbar.Snackbar

fun showSnackbar(context: Context, text: String, action: (() -> Unit)? = null, actionText: String? = context.getString(
    R.string.retry), view: View?,
anchorView: View?) {
    val snackbar = view?.let { Snackbar.make(it, text, Snackbar.LENGTH_LONG) }
    anchorView?.let { snackbar?.anchorView = it }
        if (action != null) snackbar?.setAction(actionText) {
            action.invoke()
        }
    snackbar?.show()
}