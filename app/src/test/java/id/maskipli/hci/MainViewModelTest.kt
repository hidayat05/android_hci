package id.maskipli.hci

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.google.common.truth.Truth
import id.maskipli.hci.di.network.ApiService
import id.maskipli.hci.ui.main.MainViewModel
import kotlinx.coroutines.*
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnit
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.junit.MockitoRule

/**
 * @author hidayat @on 03/08/19
 **/
@ObsoleteCoroutinesApi
@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class MainViewModelTest {

    @get:Rule
    val mockitoRule: MockitoRule = MockitoJUnit.rule()

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    lateinit var apiService: ApiService

    private lateinit var mainViewModel: MainViewModel

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        Dispatchers.setMain(newSingleThreadContext("Main thread"))
        mainViewModel = MainViewModel(apiService)
    }

    @Test
    fun `getHomeData call`() {
        val listSectionLiveData = mainViewModel.listSection.testObserver()
        runBlocking { mainViewModel.getHomeData() }
        Truth.assert_().that(listSectionLiveData).isNotNull()
    }

    @After
    fun cleared() {
        Dispatchers.resetMain()
    }

}