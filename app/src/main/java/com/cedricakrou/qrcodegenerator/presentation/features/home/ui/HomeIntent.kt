package com.cedricakrou.qrcodegenerator.presentation.features.home.ui

import android.app.Activity
import com.cedricakrou.artisanat.presentation.common.IViewIntent

sealed class HomeIntent : IViewIntent {
    object INIT : HomeIntent()

    data class Submit(
        val activity : Activity,
        val inf : Long,
        val sup : Long ) : HomeIntent()
}