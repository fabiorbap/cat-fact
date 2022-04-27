package br.fabiorachid.catfact.utils

import android.content.Context
import br.fabiorachid.catfact.utils.ConnectionUtil
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.net.wifi.WifiManager
import android.net.wifi.WifiInfo

class ConnectionUtil {

    companion object {

        fun isOnline(context: Context?): Boolean {
            val cm = context?.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val activeNetwork: NetworkInfo? = cm.activeNetworkInfo
            return activeNetwork?.isConnectedOrConnecting == true
        }

    }

}