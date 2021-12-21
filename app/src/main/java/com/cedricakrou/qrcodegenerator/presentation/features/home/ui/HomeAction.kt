package com.cedricakrou.qrcodegenerator.presentation.features.home.ui

import android.app.Activity
import com.cedricakrou.artisanat.presentation.common.IViewAction

sealed class HomeAction : IViewAction {
    object INIT : HomeAction()

    data class Submit(
        val activity : Activity,
        val inf : Long,
        val sup : Long ) : HomeAction()
}