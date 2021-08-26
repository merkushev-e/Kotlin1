package ru.gb.lesson1

import android.content.res.TypedArray
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.fragment.app.Fragment


class CoatOfArmsFragment : Fragment() {


    private lateinit var city: City

    companion object {

        const val ARG_CITY = "city"

        fun newInstance(city: City): CoatOfArmsFragment {
            val fragment = CoatOfArmsFragment()

            val args: Bundle = Bundle()
            args.putParcelable(ARG_CITY, city)
            fragment.arguments = args;
            return fragment
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null) {
            city = requireArguments().getParcelable(ARG_CITY)!!;
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_coat_of_arms, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val imageCoatOfArms: AppCompatImageView = view.findViewById(R.id.coat_of_arms)
        val images: TypedArray = resources.obtainTypedArray(R.array.coat_of_arms_imgs)
        imageCoatOfArms.setImageResource(images.getResourceId(city.imageIndex, -1))

    }


}