package com.example.myswipeview

import CustomDialogFragment
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Set up the button click event to show the dialog
        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener {
            val dialogFragment = CustomDialogFragment()
            dialogFragment.show(supportFragmentManager, "CustomDialog")
        }
    }
}