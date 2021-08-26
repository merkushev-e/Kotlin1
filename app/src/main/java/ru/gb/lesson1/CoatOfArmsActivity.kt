package ru.gb.lesson1

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class CoatOfArmsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coat_of_arms)

        if (resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            finish()
            return
        }

        if (savedInstanceState == null) {
            val details: CoatOfArmsFragment = CoatOfArmsFragment()
            details.arguments = intent.extras;

            supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.fragment_container, details).commit()
        }
    }
}