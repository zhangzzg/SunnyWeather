package model

import network.PlaceService
import network.ServiceCreator
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.RuntimeException
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

/**
 * Created by 张仲光 on 2021/1/3
 */
object SunnyWeatherNetWork {
    private val placeService = ServiceCreator.creat<PlaceService>()

    suspend fun searchPlcese(query:String) = placeService.searchPlace(query).await()

    private suspend fun <T> Call<T>.await():T{
        return suspendCoroutine {
            enqueue((object :Callback<T>{
                override fun onFailure(call: Call<T>, t: Throwable) {
                    it.resumeWithException(t)
                }

                override fun onResponse(call: Call<T>?, response: Response<T>?) {
                    val body = response?.body()
                    if(body != null){
                        it.resume(body)
                    }else{
                        it.resumeWithException(RuntimeException("response body is null"))
                    }

                }
            }))
        }
    }
}