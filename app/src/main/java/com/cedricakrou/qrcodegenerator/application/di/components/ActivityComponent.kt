package com.cedricakrou.qrcodegenerator.application.di.components

import com.cedricakrou.qrcodegenerator.presentation.common.RootBaseActivity
import com.cedricakrou.qrcodegenerator.application.di.modules.ActivityModule
import com.cedricakrou.qrcodegenerator.application.di.annotations.ActivityScope
import com.cedricakrou.qrcodegenerator.application.di.common.AppRouter
import dagger.Component

@ActivityScope
@Component( modules = [ActivityModule::class], dependencies = [ApplicationComponent::class] )
interface ActivityComponent {
    fun inject( baseActivity: RootBaseActivity)
    fun appRouter() : AppRouter
}