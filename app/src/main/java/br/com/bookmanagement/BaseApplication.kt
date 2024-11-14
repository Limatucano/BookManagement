package br.com.bookmanagement

import android.app.Application
import br.com.bookmanagement.di.DataModule
import br.com.bookmanagement.di.DatabaseModule
import br.com.bookmanagement.di.NetworkModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class BaseApplication : Application() {

    override fun onCreate() {
        startKoin {
            androidLogger()
            androidContext(this@BaseApplication)
            modules(
                NetworkModule.module,
                DatabaseModule.module,
                DataModule.module
            )
        }
        super.onCreate()
    }
}