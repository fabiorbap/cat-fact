package br.fabiorachid.catfact.view.components

import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import br.fabiorachid.catfact.R

class SimpleDialogComponent: DialogFragment() {

    fun showDialog(dialogText: String, positiveText: String,
                   negativeText: String, positiveAction: () -> Unit, negativeAction: () -> Unit) {
        activity?.let {
            val builder = AlertDialog.Builder(it)
            builder.setMessage(dialogText)
                .setPositiveButton(positiveText
                ) { _, _ ->
                    positiveAction.invoke()
                }
                .setNegativeButton(negativeText
                ) { _, _ ->
                    negativeAction.invoke()
                }
            // Create the AlertDialog object and return it
            builder.create()
            show(parentFragmentManager, "SimpleDialog")
        }
    }

    fun hideDialog() {
        dismiss()
    }

}