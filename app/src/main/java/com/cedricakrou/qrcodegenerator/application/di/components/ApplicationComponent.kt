package com.cedricakrou.qrcodegenerator.application.di.components

import com.cedricakrou.qrcodegenerator.QrCodeGeneratorApplication
import com.cedricakrou.qrcodegenerator.application.di.modules.ApplicationModule
import com.cedricakrou.qrcodegenerator.application.di.modules.NetworkModule
import com.cedricakrou.qrcodegenerator.application.di.viewmodels.DaggerViewModelFactory
import com.cedricakrou.qrcodegenerator.application.di.viewmodels.ViewModelModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Component( modules = [ApplicationModule::class, NetworkModule::class , ViewModelModule::class ] )
@Singleton
interface ApplicationComponent {

    @Component.Builder
    interface Builder {
        fun build(): ApplicationComponent

        @BindsInstance
        fun application(app: QrCodeGeneratorApplication): Builder
    }

    fun provideDaggerViewModelFactory(): DaggerViewModelFactory

}