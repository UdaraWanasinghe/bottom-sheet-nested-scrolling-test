package com.example.bottomsheettest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.button.MaterialButton

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<MaterialButton>(R.id.open_button)
        button.setOnClickListener {
            SimpleBottomSheet().show(
                supportFragmentManager,
                "BOTTOM_SHEET"
            )
        }
    }

}