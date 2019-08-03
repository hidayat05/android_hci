package id.maskipli.hci.ui.main

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.OnLifecycleEvent
import androidx.lifecycle.viewModelScope
import id.maskipli.hci.base.BaseViewModel
import id.maskipli.hci.di.network.ApiService
import id.maskipli.hci.model.Section
import kotlinx.coroutines.launch
import ru.gildor.coroutines.retrofit.Result
import ru.gildor.coroutines.retrofit.awaitResult

/**
 * @author hidayat @on 21/07/19
 **/
class MainViewModel(private val apiService: ApiService) : BaseViewModel() {

    val listSection = MutableLiveData<List<Section>>()

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun getHomeData() {
        viewModelScope.launch {
            isLoading.postValue(true)
            when (val result = apiService.getHomeData().awaitResult()) {
                is Result.Ok -> {
                    isLoading.postValue(false)
                    listSection.postValue(result.value.data)
                }
                else -> result.onErrorResponse()
            }
        }
    }

}