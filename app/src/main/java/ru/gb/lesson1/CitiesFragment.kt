package ru.gb.lesson1

import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction

class CitiesFragment : Fragment() {

    companion object {
        const val CURRENT_CITY = "CurrentCity"
    }

    private lateinit var currentCity: City
    private var isLandscape: Boolean = false
    private val DEFAULT_INDEX = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        reenterTransition = true
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_cities, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        isLandscape = (resources.configuration.orientation
                == Configuration.ORIENTATION_LANDSCAPE)

        if (savedInstanceState != null) {
            currentCity = savedInstanceState.getParcelable(CURRENT_CITY)!!
        } else {
            currentCity = City(resources.getStringArray(R.array.cities)[DEFAULT_INDEX], DEFAULT_INDEX)
        }

        if (isLandscape) {
            showLandCoatOfArms(currentCity)

        }

        initList(view)
    }

    private fun initList(view: View) {
        val layoutView: LinearLayout = view as LinearLayout
        val cities = resources.getStringArray(R.array.cities)

        for (i in 0 until cities.size) {
            var city: String = cities[i]
            val tv: TextView = TextView(context)
            tv.text = city
            tv.textSize = 30F
            layoutView.addView(tv)
            val finalIndex = i
            tv.setOnClickListener {
                currentCity = City(resources.getStringArray(R.array.cities)[finalIndex], finalIndex)
                showCoatOfArms(currentCity)

            }
        }

    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putParcelable(CURRENT_CITY, currentCity)
        super.onSaveInstanceState(outState)

    }


    private fun showCoatOfArms(currentCity: City) {
        if (isLandscape) {
            showLandCoatOfArms(currentCity)
        } else {
            showPortCoatOfArms(currentCity)
        }

    }

    private fun showLandCoatOfArms(currentCity: City) {
        val detail: CoatOfArmsFragment = CoatOfArmsFragment.newInstance(currentCity)

        val fragmentTransaction: FragmentTransaction = (requireActivity().supportFragmentManager).beginTransaction()
        fragmentTransaction.replace(R.id.coat_of_arms, detail)
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
        fragmentTransaction.commit()


    }

    private fun showPortCoatOfArms(currentCity: City) {
        val intent: Intent = Intent()
        intent.setClass(requireActivity(), CoatOfArmsActivity::class.java)
        intent.putExtra(CoatOfArmsFragment.ARG_CITY, currentCity)
        startActivity(intent)


    }


}