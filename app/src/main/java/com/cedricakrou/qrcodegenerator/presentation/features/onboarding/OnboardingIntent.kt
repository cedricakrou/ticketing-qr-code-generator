package com.cedricakrou.qrcodegenerator.presentation.features.onboarding

import com.cedricakrou.artisanat.presentation.common.IViewIntent

sealed class OnboardingIntent : IViewIntent {
    object FirstConnection : OnboardingIntent()
}