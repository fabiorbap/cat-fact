package br.fabiorachid.catfact.view.ui.favorites

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.fabiorachid.catfact.databinding.FavoritesFragmentBinding
import br.fabiorachid.catfact.utils.showSnackbar
import br.fabiorachid.catfact.view.MainActivity
import br.fabiorachid.catfact.view.ui.BaseFragment
import br.fabiorachid.catfact.viewmodel.FactsViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class FavoritesFragment : BaseFragment() {

    private var _binding: FavoritesFragmentBinding? = null
    private val factsViewModel: FactsViewModel by sharedViewModel()

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
        observeLiveData()
        factsViewModel.getFavoriteFacts()
    }

    private fun observeLiveData() {
        factsViewModel.favoriteFactsLD.observe(viewLifecycleOwner) {
            _binding?.favoriteItem?.text = it?.data?.get(it.data.size - 1)?.fact ?: ""
            _binding?.favoriteItem?.onRemoveClick = {
                showSnackbar(requireContext(), it?.data?.get(it.data.size - 1)?.fact ?: "", view = _binding?.root,
                anchorView = (requireActivity() as? MainActivity)?.navView)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}