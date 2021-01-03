package place

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hadoop.sunnywealther.R
import com.example.hadoop.sunnywealther.SunnyWealtherApplication
import kotlinx.android.synthetic.main.fragment_place.*
import ui.PlaceModel

/**
 * Created by 张仲光 on 2021/1/3
 */
class PlaceFragment : Fragment() {
    val viewModel by lazy {
        ViewModelProvider(this).get(PlaceModel::class.java)
    }
    private  lateinit var adater:PlaceAdater

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_place,container,false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val layoutManager = LinearLayoutManager(activity)
        recycleView.layoutManager = layoutManager
        adater = PlaceAdater(this,viewModel.placeList)
        recycleView.adapter = adater
        searchPlaceEdit.addTextChangedListener(object :TextWatcher{
            override fun afterTextChanged(s: Editable?) {
                val content = s.toString()
                if(content.isNotEmpty()){
                    viewModel.searchPlaces(content)
                }else{
                    recycleView.visibility = View.GONE
                    viewModel.placeList.clear()
                    adater.notifyDataSetChanged()
                }
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

        })

        viewModel.placeLiiveData.observe(viewLifecycleOwner, Observer {
            val places = it.getOrNull()
            if(places != null){
                recycleView.visibility = View.VISIBLE
                viewModel.placeList.clear()
                viewModel.placeList.addAll(places)
                adater.notifyDataSetChanged()
            }else{
                Toast.makeText(SunnyWealtherApplication.context,"未能查询到任何地点",Toast.LENGTH_LONG).show()
            }
        })

    }
}