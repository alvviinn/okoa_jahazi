package com.example.hiddengems

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.cardview.widget.CardView

class MainActivity : AppCompatActivity() {
    lateinit var btnaddhangout:Button
    lateinit var btnkarting:Button
    lateinit var btnturf:Button
    lateinit var btngirraffet:Button
    lateinit var btnpaintball:Button
    lateinit var btnpins:Button
    lateinit var btncjs:Button
    lateinit var cardmain:CardView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnaddhangout = findViewById(R.id.btn_add_hangout)
        btnturf = findViewById(R.id.btnmapturf)
        btnkarting = findViewById(R.id.btnmapkarting)
        btngirraffet = findViewById(R.id.btnmapgirraffe)
        btnpaintball = findViewById(R.id.btnmappaaintball)
        btnpins = findViewById(R.id.btnmappins)
        btncjs = findViewById(R.id.btnmapcjs)
        cardmain=findViewById(R.id.maincard)


        btnaddhangout.setOnClickListener {
            var gotoAddhangout = Intent(this, AddHangout::class.java)
            startActivity(gotoAddhangout)

        }
        btnturf.setOnClickListener {
            val gotonewactivity = Intent(this, Turf::class.java)
            startActivity(gotonewactivity)


        }
        btnkarting.setOnClickListener {
            val gotonewactivity = Intent(this, Karting::class.java)
            startActivity(gotonewactivity)

        }
        btngirraffet.setOnClickListener {
            val gotonewactivity = Intent(this,Girraffe::class.java)
            startActivity(gotonewactivity)

        }
        btnpaintball.setOnClickListener {
            val gotonewactivity = Intent(this, Paintball::class.java)
            startActivity(gotonewactivity)

        }
        btnpins.setOnClickListener {
            val gotonewactivity = Intent(this, Pins::class.java)
            startActivity(gotonewactivity)

        }
        btncjs.setOnClickListener {
            val gotonewactivity = Intent(this, Cj::class.java)
            startActivity(gotonewactivity)

        }
        cardmain.setOnClickListener{
            var gotoview =  Intent(this, View_Activity::class.java)
            startActivity(gotoview)

        }
    }
}
