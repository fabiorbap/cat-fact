package br.fabiorachid.catfact.view.components

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import br.fabiorachid.catfact.databinding.FavoriteItemComponentBinding
import com.google.android.material.card.MaterialCardView

class FavoriteItemComponent @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : MaterialCardView(context, attrs, defStyleAttr) {

    private var binding: FavoriteItemComponentBinding
    var text: String = ""
        set(value) {
            field = value
            binding.tvwText.text = value
        }

    var onRemoveClick: () -> Unit = {}
        set(value) {
            field = value
            binding.btnRemove.setOnClickListener { value.invoke() }
        }

    var removeButtonText: String = ""
        set(value) {
            field = value
            binding.btnRemove.text = value
        }

    init {
        binding = FavoriteItemComponentBinding.inflate(LayoutInflater.from(context), this, true)
    }

}
