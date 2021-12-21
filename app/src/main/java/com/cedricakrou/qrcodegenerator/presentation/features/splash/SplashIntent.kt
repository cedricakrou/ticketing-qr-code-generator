package com.cedricakrou.qrcodegenerator.presentation.features.splash

import com.cedricakrou.artisanat.presentation.common.IViewIntent

sealed class SplashIntent : IViewIntent {
    object Init : SplashIntent()
}