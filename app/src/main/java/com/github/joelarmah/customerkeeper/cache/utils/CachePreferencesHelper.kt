package com.github.joelarmah.customerkeeper.cache.utils

import android.content.Context
import android.content.SharedPreferences

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
open class CachePreferencesHelper  @Inject constructor(context: Context) {

    companion object {
        private val PREF_PACKAGE_NAME = "com.github.joelarmah.customerkeeper.preferences"
        private val PREF_KEY_LAST_CACHE = "last_cache"
    }

    private val pref: SharedPreferences

    init {
        pref = context.getSharedPreferences(PREF_PACKAGE_NAME, Context.MODE_PRIVATE)
    }

    /**
     * Store and retrieve the last time data was cached
     */
    var lastCacheTime: Long
        get() = pref.getLong(PREF_KEY_LAST_CACHE, 0)
        set(lastCache) = pref.edit().putLong(PREF_KEY_LAST_CACHE, lastCache).apply()

}