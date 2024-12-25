package info.javaway.spend_sense.di

import info.javaway.spend_sense.platform.DeviceInfo
import info.javaway.spend_sense.root.RootViewModel
import info.javaway.spend_sense.settings.SettingsViewModel
import info.javaway.spend_sense.storage.SettingsManager
import org.koin.dsl.module

object CoreModules {
    val deviceInfo = module {
        single { DeviceInfo() }
    }
}

object StorageModule {
    val settingsManager = module {
        single { SettingsManager(get()) }
    }
}

object ViewModelModule {
    val viewModels = module {
        single { RootViewModel(get()) }
        single { SettingsViewModel(get(), get()) }
    }
}