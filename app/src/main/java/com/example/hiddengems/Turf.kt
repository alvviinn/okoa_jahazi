package com.example.hiddengems

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView

class Turf : AppCompatActivity() {
    lateinit var myturf:WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_turf)
        myturf = findViewById(R.id.turfweb)

        val websettings = myturf.settings
        websettings.javaScriptEnabled = true
        myturf.loadUrl("https://goo.gl/maps/RkzXdG1E9BFYiTpq9")

    }
}