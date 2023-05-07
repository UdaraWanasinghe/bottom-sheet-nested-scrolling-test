package com.example.bottomsheettest

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.bottomsheettest.ui.OldBottomSheetDialog
import com.google.android.material.button.MaterialButton

class OldBottomSheetActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom_sheet)

        val button = findViewById<MaterialButton>(R.id.open_button)
        button.setOnClickListener {
            OldBottomSheetDialog().show(
                supportFragmentManager,
                "BOTTOM_SHEET"
            )
        }
    }

}