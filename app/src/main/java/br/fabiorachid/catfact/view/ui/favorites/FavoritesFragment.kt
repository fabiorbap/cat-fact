package br.fabiorachid.catfact.view.ui.favorites

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.fabiorachid.catfact.databinding.FragmentFavoritesBinding
import br.fabiorachid.catfact.view.ui.BaseFragment
import br.fabiorachid.catfact.viewmodel.FactsViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class FavoritesFragment : BaseFragment() {

    private var _binding: FragmentFavoritesBinding? = null
    private val factsViewModel: FactsViewModel by sharedViewModel()

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentFavoritesBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeLiveData()
        factsViewModel.getFavoriteFacts()
    }

    private fun observeLiveData() {
        factsViewModel.favoriteFactsLD.observe(viewLifecycleOwner) {
            var favorites = ""
            for (favorite in it.data ?: arrayListOf()) {
                favorites += "${favorite.fact} "
            }
            _binding?.textFavorites?.text = favorites
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}