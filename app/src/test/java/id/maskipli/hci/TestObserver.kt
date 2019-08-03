package id.maskipli.hci

import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer

/**
 * @author hidayat @on 03/08/19
 **/
open class TestObserver<T> : Observer<T> {

    private val observedValues = mutableListOf<T?>()

    override fun onChanged(value: T) {
        observedValues.add(value)
    }
}

fun <T> LiveData<T>.testObserver() = TestObserver<T>().also { observeForever(it) }