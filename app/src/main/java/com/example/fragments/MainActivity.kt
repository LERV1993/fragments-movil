package com.example.fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.google.android.material.navigation.NavigationBarView


class MainActivity : AppCompatActivity() {

    lateinit var navigation: NavigationBarView
    private val mOnNavMenu = NavigationBarView.OnItemSelectedListener { item ->
        when (item.itemId) {
            R.id.itemFragment1 -> {
                supportFragmentManager.commit {
                    replace<PrimerFragment>(R.id.frameContainer)
                    setReorderingAllowed(true)
                    addToBackStack("replacement")
                }
                return@OnItemSelectedListener true
            }
            R.id.itemFragment2 -> {
                supportFragmentManager.commit {
                    replace<SegundoFragment>(R.id.frameContainer)
                    setReorderingAllowed(true)
                    addToBackStack("replacement")
                }
                return@OnItemSelectedListener true
            }
            R.id.itemFragment3 -> {
                supportFragmentManager.commit {
                    replace<TercerFragment>(R.id.frameContainer)
                    setReorderingAllowed(true)
                    addToBackStack("replacement")
                }
                return@OnItemSelectedListener true
            }
        }

        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navigation = findViewById(R.id.navMenu)
        navigation.setOnItemSelectedListener(mOnNavMenu)

        supportFragmentManager.commit {
            replace<PrimerFragment>(R.id.frameContainer)
            setReorderingAllowed(true)
            addToBackStack("replacement")
        }
    }
}