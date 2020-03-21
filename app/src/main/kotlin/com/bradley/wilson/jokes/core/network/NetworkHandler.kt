package com.bradley.wilson.jokes.core.network

import android.content.Context
import com.bradley.wilson.jokes.core.extension.networkInfo

class NetworkHandler(private val context: Context) {
    val isConnected get() = context.networkInfo?.isConnected
}
