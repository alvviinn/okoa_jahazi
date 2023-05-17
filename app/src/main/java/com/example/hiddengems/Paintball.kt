package com.example.hiddengems

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView

class Paintball : AppCompatActivity() {
    lateinit var mypaintball:WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_paintball)

        mypaintball=findViewById(R.id.painballweb)

        val websettings =mypaintball.settings
        websettings.javaScriptEnabled = true
        mypaintball.loadUrl("https://goo.gl/maps/W3oaeHWg638eGcbX6")

    }
}