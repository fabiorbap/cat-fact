package br.fabiorachid.catfact.view.components

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.RelativeLayout
import androidx.constraintlayout.widget.ConstraintLayout
import br.fabiorachid.catfact.R

class FavoriteItemComponent @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    init {
        LayoutInflater.from(context).inflate(R.layout.favorite_item_component, this, true)
    }

}
