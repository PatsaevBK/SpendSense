package info.javaway.spend_sense

import android.app.Application
import android.content.Context
import info.javaway.spend_sense.di.initKoin
import io.github.aakira.napier.DebugAntilog
import io.github.aakira.napier.Napier
import org.koin.dsl.module

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        Napier.base(DebugAntilog())
        initKoin(
            appModule = module {
                single<Context> { this@App.applicationContext }
            }
        )
        instance = this
    }

    companion object {
        lateinit var instance: App
    }
}