package com.cedricakrou.qrcodegenerator

import android.app.Application
import com.cedricakrou.qrcodegenerator.application.di.components.ApplicationComponent
import com.cedricakrou.qrcodegenerator.application.di.components.DaggerApplicationComponent

class QrCodeGeneratorApplication : Application() {

    companion object {
        lateinit var appComponents : ApplicationComponent
    }

    override fun onCreate() {
        super.onCreate()
        appComponents = initDI()
    }


    private fun initDI() : ApplicationComponent =  DaggerApplicationComponent.builder().application( this ).build()

}