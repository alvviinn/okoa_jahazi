package com.example.hiddengems

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView

class Cj : AppCompatActivity() {
    lateinit var mycj:WebView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cj)
        mycj=findViewById(R.id.cjweb)

        val websettings = mycj.settings
        websettings.javaScriptEnabled = true
        mycj.loadUrl("https://goo.gl/maps/6KYWE87LWFXTYXLN7")
    }
}