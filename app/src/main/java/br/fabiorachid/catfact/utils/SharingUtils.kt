package br.fabiorachid.catfact.utils

import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.widget.Toast
import br.fabiorachid.catfact.R

fun shareFact(
    context: Context, message: String,
    optionalTitle: String? = context.getString(
        R.string.share_to
    ),
    onNoActivityFound: () -> Unit = {
        Toast.makeText(
            context,
            context.getString(R.string.share_no_apps_found),
            Toast.LENGTH_LONG
        ).show()
    },
) {
    val sendIntent: Intent = Intent().apply {
        action = Intent.ACTION_SEND
        putExtra(Intent.EXTRA_TEXT, message)
        type = "text/plain"
    }
    shareIntent(
        sendIntent, context.packageManager, onNoActivityFound,
        optionalTitle
    )?.let { context.startActivity(it) }
}

private fun shareIntent(
    sendIntent: Intent,
    packageManager: PackageManager,
    onNoActivityFound: () -> Unit,
    optionalTitle: String?
): Intent? {

    if (sendIntent.resolveActivity(packageManager) == null) {
        onNoActivityFound.invoke()
        return null
    }

    return Intent.createChooser(sendIntent, optionalTitle)
}