package com.example.bottomsheettest

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.bottomsheettest.ui.OldBottomSheet
import com.google.android.material.button.MaterialButton

class OldBottomSheetActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<MaterialButton>(R.id.open_button)
        button.setOnClickListener {
            OldBottomSheet().show(
                supportFragmentManager,
                "BOTTOM_SHEET"
            )
        }
    }

}