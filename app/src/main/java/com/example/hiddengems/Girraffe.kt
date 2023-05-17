package com.example.hiddengems

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView

class Girraffe : AppCompatActivity() {
    lateinit var mygirraffe:WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_girraffe)
        mygirraffe=findViewById(R.id.girraffeweb)

        val websettings = mygirraffe.settings
        websettings.javaScriptEnabled = true
        mygirraffe.loadUrl("https://goo.gl/maps/9Pj6dkMv7YqtEk4n8")

    }
}