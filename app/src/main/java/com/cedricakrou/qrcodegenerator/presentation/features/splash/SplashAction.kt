package com.cedricakrou.qrcodegenerator.presentation.features.splash

import com.cedricakrou.artisanat.presentation.common.IViewAction

sealed class SplashAction : IViewAction {
    object Init : SplashAction()
}