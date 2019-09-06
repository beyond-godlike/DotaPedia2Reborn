package com.unava.dia.dotapedia2reborn.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.unava.dia.dotapedia2reborn.R
import com.unava.dia.dotapedia2reborn.ui.heroConstructor.picker.HeroPickerActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initUI()
    }

    private fun initUI() {
        btPedia.setOnClickListener {
            // start PediaActivity
        }
        btUpdates.setOnClickListener {
            //start UpdatesActivity
        }
        btDotabuff.setOnClickListener {
            // start DotabuffActivity
        }
        btHeroConstructor.setOnClickListener {
            startActivity(Intent(this, HeroPickerActivity::class.java))
        }
    }
}
