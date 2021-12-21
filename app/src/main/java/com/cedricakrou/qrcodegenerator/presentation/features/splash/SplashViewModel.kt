package com.cedricakrou.qrcodegenerator.presentation.features.splash

import android.content.SharedPreferences
import com.cedricakrou.artisanat.presentation.common.BaseViewModel
import com.cedricakrou.qrcodegenerator.presentation.features.common.SharedPrefVar
import com.cedricakrou.qrcodegenerator.presentation.features.splash.SplashAction
import com.cedricakrou.qrcodegenerator.presentation.features.splash.SplashIntent
import com.cedricakrou.qrcodegenerator.presentation.features.splash.SplashState
import javax.inject.Inject

class SplashViewModel @Inject constructor(
    val sharedPreferences: SharedPreferences
) : BaseViewModel<
        SplashIntent,
        SplashAction,
        SplashState>() {


    override fun intentToAction(intent: SplashIntent): SplashAction {
        return when( intent ) {
            is SplashIntent.Init -> SplashAction.Init
        }
    }

    override fun handleAction(action: SplashAction) {

        launchOnUi {

            mState.postValue(

                when ( action) {
                    is SplashAction.Init -> {

                        val firstConnection : Boolean = sharedPreferences.getBoolean( SharedPrefVar.firstConnection, false )

                        if ( firstConnection ) SplashState.SignUp else SplashState.FirstConnection

                    }
                }

            )



        }

    }
}