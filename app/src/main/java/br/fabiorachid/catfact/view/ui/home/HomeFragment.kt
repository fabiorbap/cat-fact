package br.fabiorachid.catfact.view.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.fabiorachid.catfact.R
import br.fabiorachid.catfact.databinding.HomeFragmentBinding
import br.fabiorachid.catfact.model.data.local.FactLocalModel
import br.fabiorachid.catfact.model.data.remote.ResponseStatus
import br.fabiorachid.catfact.model.data.remote.app.error.Error
import br.fabiorachid.catfact.model.data.remote.app.fact.FactAppModel
import br.fabiorachid.catfact.utils.*
import br.fabiorachid.catfact.view.MainActivity
import br.fabiorachid.catfact.view.ui.BaseFragment
import br.fabiorachid.catfact.viewmodel.FactsViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class HomeFragment : BaseFragment() {

    private var _binding: HomeFragmentBinding? = null

    private val binding get() = _binding!!
    private val factsViewModel: FactsViewModel by sharedViewModel()
    private val currentFact
        get() = _binding?.tvwFact?.text?.toString() ?: ""


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = HomeFragmentBinding.inflate(inflater, container, false)
        restoreSavedState()
        factsViewModel.isFactOnFavorites(currentFact)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onFactButtonClick()
        onAddFactToFavoritesButtonClick()
        observeLiveData()
    }

    private fun restoreSavedState() {
        if (!factsViewModel.hasFactBeenLoaded) {
            getFact()
            factsViewModel.hasFactBeenLoaded = true
        } else _binding?.tvwFact?.setHtmlText(factsViewModel.loadedFact)
    }

    private fun getFact() {
        factsViewModel.getFact()
    }

    private fun addFactToFavorites() {
        factsViewModel.addFactToFavorites(currentFact)
    }

    private fun observeLiveData() {
        observeGetFactLiveData()
        observeAddFactToFavoritesLiveData()
        observeIsFactOnFavoritesLiveData()
        observeFactOnFavorites()
        observeOnDeleteFact()
    }

    private fun observeOnDeleteFact() {
        factsViewModel.deleteFavoriteFactLD.observe(viewLifecycleOwner) {
            when (it.status) {
                ResponseStatus.LOADING -> {}
                ResponseStatus.SUCCESS -> onDeleteFavoriteSuccess()
                ResponseStatus.ERROR -> onDeleteFavoriteError()
            }
        }
    }

    private fun onDeleteFavoriteSuccess() {
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

    private fun observeFactOnFavorites() {
        factsViewModel.factFromFavoritesLD.observe(viewLifecycleOwner) {
            deleteFromFavorites(it)
        }
    }

    private fun observeIsFactOnFavoritesLiveData() {
        factsViewModel.isFactOnFavoritesLD.observe(viewLifecycleOwner) {
            if (it) _binding?.btnAddFact?.toggleOn()
            else _binding?.btnAddFact?.toggleOff()
        }
    }

    private fun observeGetFactLiveData() {
        factsViewModel.factLD.observe(viewLifecycleOwner) {
            when (it.status) {
                ResponseStatus.LOADING -> onGetFactLoading()
                ResponseStatus.SUCCESS -> onGetFactSuccess(it.data)
                ResponseStatus.ERROR -> onGetFactError(it.error)
            }
        }
    }

    private fun observeAddFactToFavoritesLiveData() {
        factsViewModel.addFavoriteFactLD.observe(viewLifecycleOwner) {
            when (it.status) {
                ResponseStatus.LOADING -> {}
                ResponseStatus.SUCCESS -> showSnackbar(
                    requireContext(),
                    getString(R.string.home_add_favorite_success),
                    view = _binding?.root,
                    anchorView = (requireActivity() as? MainActivity)?.navView
                )
                ResponseStatus.ERROR -> showSnackbar(
                    requireContext(),
                    getString(R.string.generic_error),
                    view = _binding?.root,
                    anchorView = (requireActivity() as? MainActivity)?.navView
                )
            }
        }
    }

    private fun onFactButtonClick() {
        _binding?.btnFact?.setOnClickListener {
            getFact()
        }
    }

    private fun onAddFactToFavoritesButtonClick() {
        _binding?.btnAddFact?.setOnClickListener {
            if (_binding?.btnAddFact?.isChecked == false) factsViewModel.getFavoriteFact(currentFact)
            else addFactToFavorites()
        }
    }

    private fun onGetFactLoading() {
    }

    private fun onGetFactSuccess(it: FactAppModel?) {
        _binding?.tvwFact?.setHtmlText(it?.fact ?: "")
        factsViewModel.isFactOnFavorites(it?.fact ?: "")
    }

    private fun onGetFactError(error: Error?) {
        if (!ConnectionUtil.isOnline(requireContext())) showNetworkError(
            this::getFact,
            _binding?.root
        )
        else showGenericError(this::getFact, error?.errorMessage ?: "", _binding?.root)
    }

    override fun onPause() {
        if (_binding?.tvwFact?.text?.isNotEmpty() == true) factsViewModel.loadedFact = _binding?.tvwFact?.text.toString()
        super.onPause()
    }

    private fun deleteFromFavorites(factLocalModel: FactLocalModel) {
        factsViewModel.deleteFactFromFavorites(factLocalModel)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}