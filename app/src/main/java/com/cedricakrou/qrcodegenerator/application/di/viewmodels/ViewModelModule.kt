package com.cedricakrou.qrcodegenerator.application.di.viewmodels

import androidx.lifecycle.ViewModel
import com.cedricakrou.qrcodegenerator.application.di.annotations.ViewModelKey
import com.cedricakrou.qrcodegenerator.presentation.features.home.ui.HomeViewModel
import com.cedricakrou.qrcodegenerator.presentation.features.onboarding.OnBoardingViewModel
import com.cedricakrou.qrcodegenerator.presentation.features.splash.SplashViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey( SplashViewModel::class )
    abstract fun bindSplashViewModel( vm : SplashViewModel) : ViewModel

    @Binds
    @IntoMap
    @ViewModelKey( OnBoardingViewModel::class )
    abstract fun bindOnBoardingViewModel( vm : OnBoardingViewModel) : ViewModel

    @Binds
    @IntoMap
    @ViewModelKey( HomeViewModel::class )
    abstract fun bindHomeViewModel( vm : HomeViewModel) : ViewModel
}