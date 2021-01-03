package logic

import androidx.lifecycle.liveData
import kotlinx.coroutines.Dispatchers
import model.Place
import model.SunnyWeatherNetWork
import java.lang.Exception
import java.lang.RuntimeException

/**
 * Created by 张仲光 on 2021/1/3
 */
object Repository {
    fun searchPlace(query:String) = liveData(Dispatchers.IO){
        val result = try {
            val placeResponse = SunnyWeatherNetWork.searchPlcese(query)
            if(placeResponse.status == "ok"){
                val place = placeResponse.place
                Result.success(place)
            }else{
                Result.failure(RuntimeException("response status is ${placeResponse.status}"))
            }
        }catch (e:Exception){
            Result.failure<List<Place>>(e)
        }
        emit(result)
    }
}