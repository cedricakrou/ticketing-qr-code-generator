package com.cedricakrou.qrcodegenerator.presentation.features.home.ui

import com.cedricakrou.artisanat.presentation.common.IViewState

sealed class HomeState : IViewState {

    object LOADING : HomeState()
    object FINISH : HomeState()

}