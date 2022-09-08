package com.android.newsfeed.utils

import android.app.Activity
import android.content.Context
import android.content.ContextWrapper
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.activity.ComponentActivity
import androidx.browser.customtabs.CustomTabsIntent
import androidx.core.content.ContextCompat
import com.android.newsfeed.R

fun Activity.openChromeTab(url: String) {
    val packageName = "com.android.chrome"

    val builder = CustomTabsIntent.Builder()

    val customBuilder = with(builder) {
        setShowTitle(true)
        setInstantAppsEnabled(true)
        setToolbarColor(ContextCompat.getColor(this@openChromeTab, R.color.chrome_background))
        build()
    }

    if (isAppInstalled(packageName)) {
        customBuilder.intent.setPackage(packageName)
        customBuilder.launchUrl(this, Uri.parse(url))
    } else {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(intent)
    }
}

fun Context.getActivity(): ComponentActivity? = when (this) {
    is ComponentActivity -> this
    is ContextWrapper -> baseContext.getActivity()
    else -> null
}

fun Context.isAppInstalled(packageName: String): Boolean {
    val intent = Intent(Intent.ACTION_VIEW)
    if (intent.resolveActivity(packageManager) != null) {
        try {
            packageManager.getPackageInfo(packageName, PackageManager.GET_ACTIVITIES)
            return true
        } catch (ignore: PackageManager.NameNotFoundException) {
        }
    }
    return false
}
