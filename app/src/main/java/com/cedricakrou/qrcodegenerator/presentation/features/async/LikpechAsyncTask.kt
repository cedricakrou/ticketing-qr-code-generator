package com.cedricakrou.qrcodegenerator.presentation.features.async

import android.app.Activity
import android.graphics.Bitmap
import android.os.AsyncTask
import androidx.lifecycle.MutableLiveData
import com.cedricakrou.qrcodegenerator.domain.entities.QrCode
import com.cedricakrou.qrcodegenerator.presentation.Utils
import com.cedricakrou.qrcodegenerator.presentation.features.home.ui.HomeState
import com.fasterxml.jackson.databind.ObjectMapper

class LikpechAsyncTask(val activity: Activity, val state : MutableLiveData<HomeState>, val inf : Long, val sup : Long ) : AsyncTask<Unit, Unit, Unit>() {

    override fun onPreExecute() {

        state.postValue(

            HomeState.LOADING

        )

    }

    override fun doInBackground(vararg p0: Unit?) {

        Utils.verifyFile( Utils.file )

        for ( i in inf .. sup  ) {

            // create qr code

            val  qrCode : Bitmap? = Utils.createQrCode(
                context = activity.applicationContext,
                message = ObjectMapper().writeValueAsString(
                    QrCode(
                        ticketNumber = i.toString(),
                    )
                )
            )

            // save qr code in phone

            if ( qrCode != null ) {

                Utils.saveImage(
                    activity = activity,
                    myBitmap = qrCode,
                    number = i
                )

            }


        }

    }

    override fun onPostExecute(result: Unit?) {

        state.postValue(

            HomeState.FINISH
        )

    }
}