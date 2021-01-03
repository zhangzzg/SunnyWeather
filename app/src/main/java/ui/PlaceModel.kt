package ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import logic.Repository
import model.Place

/**
 * Created by 张仲光 on 2021/1/3
 */
class PlaceModel:ViewModel() {
    private val searchLivedata = MutableLiveData<String>()
    val placeList = ArrayList<Place>()
    val placeLiiveData = Transformations.switchMap(searchLivedata){
        Repository.searchPlace(it)
    }

    fun searchPlaces(query:String){
        searchLivedata.value = query
    }

}