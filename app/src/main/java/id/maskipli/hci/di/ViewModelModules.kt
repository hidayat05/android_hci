package id.maskipli.hci.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import id.maskipli.hci.ui.main.MainViewModel

/**
 * @author hidayat @on 21/07/19
 **/
object ViewModelModules {

    val module = module {

        viewModel { MainViewModel(get()) }

    }
}