package br.fabiorachid.catfact.utils

import androidx.appcompat.widget.AppCompatImageButton
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