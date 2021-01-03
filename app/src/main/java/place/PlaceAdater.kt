package place

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.hadoop.sunnywealther.R
import model.Place
import org.w3c.dom.DocumentFragment

/**
 * Created by 张仲光 on 2021/1/3
 */
class PlaceAdater(private val fragment: Fragment,private val placeList:List<Place>):RecyclerView.Adapter<PlaceAdater.ViewHolder>() {

    inner class ViewHolder(view: View):RecyclerView.ViewHolder(view){
        val placeName :TextView = view.findViewById(R.id.placeName)
        val placeAddress :TextView = view.findViewById(R.id.placeAddress)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.place_item,parent,false)
        return  ViewHolder(view)
    }

    override fun getItemCount() = placeList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val place = placeList[position]
        holder.placeName.text = place.name
        holder.placeAddress.text = place.address
    }
}