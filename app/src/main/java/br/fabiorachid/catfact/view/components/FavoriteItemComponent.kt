package br.fabiorachid.catfact.view.components

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import br.fabiorachid.catfact.databinding.FavoriteItemComponentBinding

class FavoriteItemComponent @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    private var binding: FavoriteItemComponentBinding
    var text: String = ""
        set(value) {
            field = value
            binding.tvwText.text = value
        }

    var onRemoveClick: () -> Unit = {}
        set(value) {
            field = value
            binding.imgBtnRemove.setOnClickListener { value.invoke() }
        }

    init {
        binding = FavoriteItemComponentBinding.inflate(LayoutInflater.from(context), this, true)
    }

}
