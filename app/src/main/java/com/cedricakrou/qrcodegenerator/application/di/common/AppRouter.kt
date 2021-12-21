package com.cedricakrou.qrcodegenerator.application.di.common

import com.cedricakrou.qrcodegenerator.application.di.annotations.ActivityScope
import com.cedricakrou.qrcodegenerator.presentation.common.RootBaseActivity
import javax.inject.Inject

@ActivityScope
class AppRouter @Inject constructor( private val activity: RootBaseActivity)