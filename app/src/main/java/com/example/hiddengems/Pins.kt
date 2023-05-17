package com.example.hiddengems

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView

class Pins : AppCompatActivity() {
    lateinit var mypins:WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pins)
        mypins = findViewById(R.id.pinsweb)

        val websettings = mypins.settings
        websettings.javaScriptEnabled = true
        mypins.loadUrl("https://goo.gl/maps/JdtBGsiN73FGSzJp9")

    }
}