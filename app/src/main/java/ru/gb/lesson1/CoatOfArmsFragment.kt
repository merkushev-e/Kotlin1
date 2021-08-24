package ru.gb.lesson1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment


private const val ARG_INDEX = "index"
private lateinit var index: Int


class CoatOfArmsFragment : Fragment() {

    private var param1: String? = null

    companion object {

        fun newInstance(index: Int) {
            val fragment = CoatOfArmsFragment()

            val args: Bundle = Bundle()
            args.putInt(ARG_INDEX, index)
            fragment.arguments = args;
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_INDEX)

        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_coat_of_arms, container, false)
    }


}