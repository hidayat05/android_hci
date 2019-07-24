package id.maskipli.hci.base

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.gildor.coroutines.retrofit.Result

/**
 * @author hidayat @on 21/07/19
 **/
open class BaseViewModel : ViewModel(), LifecycleObserver {

    val isLoading = MutableLiveData<Boolean>()
    val errorMessage = MutableLiveData<String>()

    fun <T> T?.onErrorResponse() {
        when (this) {
            is Result.Error -> {
                isLoading.postValue(false)
                errorMessage.postValue(exception.message())
            }
            is Result.Exception -> {
                isLoading.postValue(false)
                errorMessage.postValue(exception.message)
            }
        }
    }
}