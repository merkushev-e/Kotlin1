package ru.gb.lesson1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment

class CitiesFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_cities, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initList(view)
    }

    private fun initList(view: View) {
        val layoutView: LinearLayout = view as LinearLayout
        val cities = resources.getStringArray(R.array.cities)

        for (i in 0 until cities.size){
            var city: String = cities[i]
            val tv: TextView = TextView(context)
            tv.text = city
            tv.textSize = 30F
            layoutView.addView(tv)
        }

    }


}