package com.github.joelarmah.customerkeeper.ui.app

import android.app.Application
import com.github.joelarmah.customerkeeper.presentation.utils.PresentationPreferencesHelper
import com.github.joelarmah.customerkeeper.ui.core.theme.ThemeUtils
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class CustomerKeeperApp : Application() {

    @Inject
    lateinit var themeUtils: ThemeUtils

    @Inject
    lateinit var preferencesHelper: PresentationPreferencesHelper

    override fun onCreate() {
        super.onCreate()
        initNightMode()
    }

    /**
     * Initialize Night Mode based on user last saved state (day/night themes).
     */
    private fun initNightMode() {
        themeUtils.setNightMode(preferencesHelper.isNightMode)
    }
}