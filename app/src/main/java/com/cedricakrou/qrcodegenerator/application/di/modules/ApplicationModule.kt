package com.cedricakrou.qrcodegenerator.application.di.modules

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import com.cedricakrou.qrcodegenerator.QrCodeGeneratorApplication
import com.cedricakrou.qrcodegenerator.infrastructure.remote.ApiService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class ApplicationModule {

    @Provides
    fun provideApplicationContext( application : QrCodeGeneratorApplication) : Context = application.applicationContext


    @Provides
    fun sharedPreferences( context: Context ) : SharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)

    @Provides
    fun providesSharedPreferencesEditor( sharedPreferences: SharedPreferences ) : SharedPreferences.Editor = sharedPreferences.edit()

    @Provides
    @Singleton
    fun providesApiService( retrofit: Retrofit) : ApiService = retrofit.create( ApiService::class.java )

}