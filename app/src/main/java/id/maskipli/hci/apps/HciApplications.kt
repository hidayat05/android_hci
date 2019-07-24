package id.maskipli.hci.apps

import android.app.Application
import id.maskipli.hci.di.NetworkModules
import id.maskipli.hci.di.ViewModelModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

/**
 * @author hidayat @on 21/07/19
 **/
class HciApplications : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@HciApplications)
            modules(
                listOf(
                    NetworkModules.module,
                    ViewModelModules.module
                )
            )
        }
    }
}