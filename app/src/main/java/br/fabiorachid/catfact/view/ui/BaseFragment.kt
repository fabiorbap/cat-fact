package br.fabiorachid.catfact.view.ui

import android.view.View
import androidx.fragment.app.Fragment
import br.fabiorachid.catfact.R
import br.fabiorachid.catfact.utils.showSnackbar
import br.fabiorachid.catfact.view.MainActivity

open class BaseFragment : Fragment() {

    protected fun showNetworkError(action: (() -> Unit)?, view: View?) {
        showSnackbar(requireContext(), getString(R.string.network_error), action, view = view, anchorView = (activity as? MainActivity)?.navView)
    }

    protected fun showGenericError(action: (() -> Unit)?, errorMessage: String, view: View?) {
        showSnackbar(requireContext(),
            errorMessage.ifEmpty { getString(R.string.generic_error) }, action, view = view, anchorView = (activity as? MainActivity)?.navView)
    }

}