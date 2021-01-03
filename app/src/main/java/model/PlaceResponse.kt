package model

import com.google.gson.annotations.SerializedName

/**
 * Created by 张仲光 on 2021/1/2
 */

data class PlaceResPonse(val status:String,val place:List<Place>)
data class Place(val name:String,val location:Location,@SerializedName("formatted_address") val address:String)
data class Location (val lng:String,val lat:String)