package com.myteam11.upifetch_lib

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.util.Log

data class UpiApp(val appName: String, val packageName: String)

class UpiFinder {

    companion object {

        @JvmStatic
        fun getUpiApps(context: Context): ArrayList<String> {
            val upiAppsList = ArrayList<String>()
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("upi://pay?"))
            val resolveInfoList = context.packageManager.queryIntentActivities(intent, 0)

            for (resolveInfo in resolveInfoList) {
                val appName = resolveInfo.loadLabel(context.packageManager).toString()
                val packageName = resolveInfo.activityInfo.packageName
                upiAppsList.add("$appName|$packageName") // Use "|" as delimiter
                Log.d("UpiFinder", "Found UPI app: $appName - $packageName")
            }
            return upiAppsList
        }

        @JvmStatic
        fun openApp(context: Context, packageName: String) {
            try {
                val launchIntent = context.packageManager.getLaunchIntentForPackage(packageName)
                if (launchIntent != null) {
                    context.startActivity(launchIntent)
                } else {
                    Log.e("UpiFinder", "No launch intent for $packageName")
                }
            } catch (e: Exception) {
                Log.e("UpiFinder", "Failed to open app: $packageName", e)
            }
        }
    }
}
