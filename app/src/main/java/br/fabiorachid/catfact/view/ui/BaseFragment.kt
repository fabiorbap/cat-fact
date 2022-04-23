package br.fabiorachid.catfact.view.ui

import android.view.View
import androidx.fragment.app.Fragment
import br.fabiorachid.catfact.R
import br.fabiorachid.catfact.utils.showSnackbar

open class BaseFragment : Fragment() {

    protected fun showNetworkError(action: (() -> Unit)?, view: View?) {
        showSnackbar(requireContext(), getString(R.string.network_error_text), action, view = view)
    }

    protected fun showGenericError(action: (() -> Unit)?, view: View?) {
        showSnackbar(requireContext(), getString(R.string.generic_error_text), action, view = view)
    }

}