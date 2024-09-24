package com.chunkytofustudios.native_geofence

import NativeGeofenceApi
import android.content.Context
import android.util.Log
import com.chunkytofustudios.native_geofence.api.NativeGeofenceApiImpl
import io.flutter.embedding.engine.plugins.FlutterPlugin

class NativeGeofencePlugin : FlutterPlugin {
    private var context: Context? = null

    companion object {
        @JvmStatic
        private val TAG = "NativeGeofencePlugin"
    }

    override fun onAttachedToEngine(binding: FlutterPlugin.FlutterPluginBinding) {
        NativeGeofenceApi.setUp(
            binding.binaryMessenger,
            NativeGeofenceApiImpl(binding.applicationContext)
        )
        Log.i(TAG, "NativeGeofenceApi setup complete.")
    }

    override fun onDetachedFromEngine(binding: FlutterPlugin.FlutterPluginBinding) {
        context = null
    }
}