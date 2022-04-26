package br.fabiorachid.catfact.view.ui.favorites

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import br.fabiorachid.catfact.R
import br.fabiorachid.catfact.databinding.FavoritesFragmentBinding
import br.fabiorachid.catfact.model.data.local.FactLocalModel
import br.fabiorachid.catfact.model.data.remote.ResponseStatus
import br.fabiorachid.catfact.utils.showSnackbar
import br.fabiorachid.catfact.view.MainActivity
import br.fabiorachid.catfact.view.ui.BaseFragment
import br.fabiorachid.catfact.viewmodel.FactsViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class FavoritesFragment : BaseFragment() {

    private var _binding: FavoritesFragmentBinding? = null
    private val factsViewModel: FactsViewModel by sharedViewModel()
    private val favoritesList = mutableListOf<FactLocalModel>()
    private lateinit var adapter: FavoritesAdapter

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FavoritesFragmentBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        observeLiveData()
        factsViewModel.getFavoriteFacts()
    }

    private fun observeLiveData() {
        observeFavoriteFactsLiveData()
        observeDeleteFactLiveData()
    }

    private fun observeFavoriteFactsLiveData() {
        factsViewModel.favoriteFactsLD.observe(viewLifecycleOwner) {
            favoritesList.clear()
            //From most recent to oldest favorite
            favoritesList.addAll(it.data?.reversed() ?: listOf())
            adapter.notifyDataSetChanged()
        }
    }

    private fun observeDeleteFactLiveData() {
        factsViewModel.deleteFavoriteFactLD.observe(viewLifecycleOwner) {
            when (it.status) {
                ResponseStatus.LOADING -> {}
                ResponseStatus.SUCCESS -> onDeleteFavoriteSuccess(it.data)
                ResponseStatus.ERROR -> onDeleteFavoriteError()
            }
        }
    }

    private fun onDeleteFavoriteSuccess(id: Int?) {
        val position = favoritesList.indexOfFirst {favorite -> favorite.factId == id }
        favoritesList.removeIf { favorite -> favorite.factId == id }
        adapter.notifyItemRemoved(position)
        showSnackbar(
            requireContext(), getString(R.string.favorites_delete_fact_success),
            view = _binding?.root, anchorView = (requireActivity() as MainActivity).navView
        )
    }

    private fun onDeleteFavoriteError() {
        showSnackbar(
            requireContext(), getString(R.string.favorites_delete_fact_error),
            view = _binding?.root, anchorView = (requireActivity() as MainActivity).navView
        )
    }

    private fun setupAdapter() {
        adapter = FavoritesAdapter(favoritesList, this::onRemoveClick)
    }

    private fun setupRecyclerView() {
        setupAdapter()
        _binding?.rcvFavoritesList?.adapter = adapter
        _binding?.rcvFavoritesList?.layoutManager = LinearLayoutManager(requireContext())
        _binding?.rcvFavoritesList?.addItemDecoration(VerticalSpacingDecoration(resources.getDimension(R.dimen.margin_medium).toInt()))
    }

    private fun onRemoveClick(id: Int) {
        val favorite = favoritesList.find { favorite -> favorite.factId == id }
        factsViewModel.deleteFactFromFavorites(favorite ?: FactLocalModel(0, ""))
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}