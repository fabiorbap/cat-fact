package br.fabiorachid.catfact.view.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import br.fabiorachid.catfact.R
import br.fabiorachid.catfact.databinding.FragmentHomeBinding
import br.fabiorachid.catfact.model.data.ErrorType
import br.fabiorachid.catfact.model.data.ResponseStatus
import br.fabiorachid.catfact.model.data.app.fact.FactAppModel
import br.fabiorachid.catfact.model.data.mapError
import br.fabiorachid.catfact.utils.showSnackbar
import br.fabiorachid.catfact.view.ui.BaseFragment
import br.fabiorachid.catfact.viewmodel.FactsViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class HomeFragment : BaseFragment() {

    private var _binding: FragmentHomeBinding? = null

    private val binding get() = _binding!!
    private val factsViewModel: FactsViewModel by sharedViewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onFactButtonClick()
        observeLiveData()
        getFact()
    }

    private fun getFact() {
        factsViewModel.getFact()
    }

    private fun observeLiveData() {
        factsViewModel.factLD.observe(viewLifecycleOwner, Observer {
            when (it.status) {
                ResponseStatus.LOADING -> onGetFactLoading()
                ResponseStatus.SUCCESS -> onGetFactSuccess(it.data)
                ResponseStatus.ERROR -> onGetFactError(it.error)
            }
        })
    }

    private fun onFactButtonClick() {
        _binding?.btnFact?.setOnClickListener {
            getFact()
        }
    }

    private fun onGetFactLoading() {

    }

    private fun onGetFactSuccess(it: FactAppModel?) {
        _binding?.textHome?.text = it?.fact
    }

    private fun onGetFactError(error: Error?) {
        when(mapError(error as? Throwable, requireContext())) {
            ErrorType.NETWORK -> showNetworkError(this::getFact, _binding?.constraintRoot)
            ErrorType.DEFAULT -> showGenericError(this::getFact, _binding?.constraintRoot)
            else -> showGenericError(this::getFact, _binding?.constraintRoot)
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}