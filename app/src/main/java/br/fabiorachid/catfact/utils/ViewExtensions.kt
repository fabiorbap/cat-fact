package br.fabiorachid.catfact.utils

import android.text.Html
import androidx.appcompat.widget.AppCompatTextView

fun AppCompatTextView.setHtmlText(text: String) {
    this.text = Html.fromHtml(text, Html.FROM_HTML_MODE_COMPACT)
}