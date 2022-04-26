package br.fabiorachid.catfact.view.components

import android.content.Context
import android.util.AttributeSet
import androidx.core.content.ContextCompat
import br.fabiorachid.catfact.R

class FavoriteButtonComponent @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : androidx.appcompat.widget.AppCompatToggleButton(context, attrs, defStyleAttr) {

    init {
        buttonDrawable = ContextCompat.getDrawable(context, R.drawable.ic_baseline_favorite_border_36)
        buttonDrawable?.setTint(ContextCompat.getColor(context, android.R.color.holo_red_dark))
        text = ""
        setupButton()
    }

    private fun setupButton() {
        setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) showActiveDrawable()
            else showInactiveDrawable()
        }
    }

    private fun setState(isChecked: Boolean) {
        this.isChecked = isChecked
    }

    fun toggleOn() {
        setState(true)
    }

    fun toggleOff() {
        setState(false)
    }

    private fun showActiveDrawable() {
        buttonDrawable = ContextCompat.getDrawable(context, R.drawable.ic_baseline_favorite_36)
        buttonDrawable?.setTint(ContextCompat.getColor(context, android.R.color.holo_red_dark))
    }

    private fun showInactiveDrawable() {
        buttonDrawable = ContextCompat.getDrawable(context, R.drawable.ic_baseline_favorite_border_36)
        buttonDrawable?.setTint(ContextCompat.getColor(context, android.R.color.holo_red_dark))
    }

}