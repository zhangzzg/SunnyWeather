package network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by 张仲光 on 2021/1/2
 */
object ServiceCreator {
    private const val  BASE_URL ="https://api.caiyunapp.com/"
    private val retrofit = Retrofit.Builder().
        addConverterFactory(GsonConverterFactory.create()).baseUrl(BASE_URL).build()
    fun <T> creat(serverClass:Class<T>):T = retrofit.create(serverClass)

    inline fun <reified T> creat():T = creat(T::class.java)

}