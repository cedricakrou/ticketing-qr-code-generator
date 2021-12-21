package com.cedricakrou.qrcodegenerator.presentation.features.onboarding

import com.cedricakrou.artisanat.presentation.common.IViewAction


sealed class OnboardingAction : IViewAction {
    object FirstConnection : OnboardingAction()
}