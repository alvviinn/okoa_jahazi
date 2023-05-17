package com.example.hiddengems

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView

class Karting : AppCompatActivity() {
    lateinit var mykarting:WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_karting)

        mykarting=findViewById(R.id.kartingweb)

        val websettings = mykarting.settings
        websettings.javaScriptEnabled = true
        mykarting.loadUrl("https://goo.gl/maps/X44ocZTgiBCyFYA79")

    }
}