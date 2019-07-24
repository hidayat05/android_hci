package id.maskipli.hci.di.network

import id.maskipli.hci.model.response.HomeResponse
import retrofit2.Call
import retrofit2.http.GET

/**
 * @author hidayat @on 21/07/19
 **/
interface ApiService {

    @GET("home")
    fun getHomeData(): Call<HomeResponse>

}