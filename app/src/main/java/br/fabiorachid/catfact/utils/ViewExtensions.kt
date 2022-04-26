package br.fabiorachid.catfact.utils

import android.os.Build
import android.text.Html
import androidx.appcompat.widget.AppCompatImageButton
import androidx.appcompat.widget.AppCompatTextView
import androidx.appcompat.widget.AppCompatToggleButton

fun AppCompatImageButton.enable() {
    isEnabled = true
}

fun AppCompatImageButton.disable() {
    isEnabled = false
}

fun AppCompatToggleButton.enable() {
    isEnabled = true
}

fun AppCompatToggleButton.disable() {
    isEnabled = false
}

fun AppCompatTextView.setHtmlText(text: String) {
    this.text = Html.fromHtml(text, Html.FROM_HTML_MODE_COMPACT)
}