package br.fabiorachid.catfact.view.ui.favorites

import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.recyclerview.widget.RecyclerView
import br.fabiorachid.catfact.model.data.local.FactLocalModel
import br.fabiorachid.catfact.view.components.FavoriteItemComponent

class FavoritesAdapter (var favoritesList: List<FactLocalModel>,
                        var onRemoveClick: (id: Int) -> Unit, var onShareClick: (shareText: String) -> Unit): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = FavoriteItemComponent(parent.context)
        view.layoutParams = RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        return FavoriteViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val itemView = (holder as FavoriteViewHolder).itemView as FavoriteItemComponent
        val listItem = favoritesList[position]
        with(itemView) {
            text = listItem.fact
            onRemoveClick = { this@FavoritesAdapter.onRemoveClick.invoke(listItem.factId)}
            onShareClick = { this@FavoritesAdapter.onShareClick.invoke(listItem.fact)}
        }
    }

    override fun getItemCount(): Int = favoritesList.size

    class FavoriteViewHolder(view: FavoriteItemComponent): RecyclerView.ViewHolder(view)

}