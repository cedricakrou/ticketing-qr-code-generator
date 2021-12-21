package com.cedricakrou.qrcodegenerator.presentation.features.home.ui

import android.graphics.Bitmap
import com.cedricakrou.artisanat.presentation.common.BaseViewModel
import com.cedricakrou.qrcodegenerator.domain.entities.QrCode
import com.cedricakrou.qrcodegenerator.presentation.Utils
import com.fasterxml.jackson.databind.ObjectMapper
import javax.inject.Inject


class HomeViewModel @Inject constructor(
) : BaseViewModel<
        HomeIntent,
        HomeAction,
        HomeState>()
{
    override fun intentToAction(intent: HomeIntent): HomeAction {

        return when( intent ) {
            is HomeIntent.INIT -> HomeAction.INIT
            is HomeIntent.Submit -> HomeAction.Submit(
                activity= intent.activity,
                inf = intent.inf,
                sup = intent.sup
            )
        }

    }

    override fun handleAction(action: HomeAction) {

        launchOnUi {

            when( action ) {

                is HomeAction.INIT -> {
                }

                is HomeAction.Submit -> {

                    mState.postValue(
                        HomeState.LOADING
                    )

                    for ( i in action.inf .. action.sup  ) {

                        // create qr code

                        val  qrCode : Bitmap? = Utils.createQrCode(
                            context = action.activity.applicationContext,
                            message = ObjectMapper().writeValueAsString(
                                QrCode(
                                    ticketNumber = i.toString(),
                                    ))
                                )

                        // save qr code in phone

                        if ( qrCode != null ) {

                            Utils.saveImage(
                                activity = action.activity,
                                myBitmap = qrCode,
                                number = i
                            )

                        }

                    }

                    mState.postValue(
                        HomeState.FINISH
                    )

                }

            }

        }

    }
}