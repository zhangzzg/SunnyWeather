package network

import com.example.hadoop.sunnywealther.SunnyWealtherApplication
import model.PlaceResPonse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by 张仲光 on 2021/1/2
 */
interface PlaceService {
    @GET("v2/place?token=${SunnyWealtherApplication.TOKEN}&lang=zh_CN")
    fun searchPlace(@Query("query") query:String): Call<PlaceResPonse>
}