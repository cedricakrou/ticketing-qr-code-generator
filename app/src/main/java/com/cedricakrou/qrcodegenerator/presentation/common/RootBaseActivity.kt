package com.cedricakrou.qrcodegenerator.presentation.common

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.cedricakrou.qrcodegenerator.QrCodeGeneratorApplication
import com.cedricakrou.qrcodegenerator.application.di.common.AppRouter
import com.cedricakrou.qrcodegenerator.application.di.components.ActivityComponent
import com.cedricakrou.qrcodegenerator.application.di.components.DaggerActivityComponent
import com.cedricakrou.qrcodegenerator.application.di.modules.ActivityModule
import com.cedricakrou.qrcodegenerator.application.di.viewmodels.DaggerViewModelFactory
import javax.inject.Inject

/**
 * Cette classe represente la base de toutes les activités de l'application
 */

open class RootBaseActivity : AppCompatActivity() {


    private val activityComponent : ActivityComponent by lazy {


        DaggerActivityComponent
            .builder()
            .activityModule( ActivityModule( this ) )
            .applicationComponent( QrCodeGeneratorApplication.appComponents )
            .build()
    }

    @Inject
    lateinit var appRouter: AppRouter

    @Inject
    lateinit var viewModelFactory: DaggerViewModelFactory


    override fun onCreate(savedInstanceState: Bundle?) {
        activityComponent.inject( this )
        super.onCreate(savedInstanceState)
    }

}