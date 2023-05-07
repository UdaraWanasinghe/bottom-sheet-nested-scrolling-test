package com.example.bottomsheettest

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.bottomsheettest.ui.NewBottomSheetDialog
import com.google.android.material.button.MaterialButton

class NewBottomSheetActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom_sheet)

        val button = findViewById<MaterialButton>(R.id.open_button)
        button.setOnClickListener {
            NewBottomSheetDialog().show(
                supportFragmentManager,
                "BOTTOM_SHEET"
            )
        }
    }

}