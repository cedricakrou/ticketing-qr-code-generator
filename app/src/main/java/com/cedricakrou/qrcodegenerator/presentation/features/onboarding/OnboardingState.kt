package com.cedricakrou.qrcodegenerator.presentation.features.onboarding

import com.cedricakrou.artisanat.presentation.common.IViewState

sealed class OnboardingState : IViewState {
    object FirstConnection : OnboardingState()
}