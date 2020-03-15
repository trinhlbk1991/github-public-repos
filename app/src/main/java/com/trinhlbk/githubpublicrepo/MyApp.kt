package com.trinhlbk.githubpublicrepo

import android.app.Application
import com.trinhlbk.githubpublicrepo.di.modules.*
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApp : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MyApp)
            modules(
                appModule,
                networkModule,
                repositoryModule,
                useCaseModule,
                viewModelModule
            )
        }
    }
}