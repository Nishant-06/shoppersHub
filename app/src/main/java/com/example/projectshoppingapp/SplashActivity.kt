package com.example.projectshoppingapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : AppCompatActivity() {
    lateinit var handler: Handler
    var myanim: Animation?=null
    var ranim: Animation?=null
    var lanim: Animation?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        val backgroundImg: ImageView =splash_logo_id
        myanim= AnimationUtils.loadAnimation(this,R.anim.slide)
        ranim= AnimationUtils.loadAnimation(this,R.anim.slide_right)
        lanim= AnimationUtils.loadAnimation(this,R.anim.slide_left)
        backgroundImg.startAnimation(myanim)
        shoppers_id.startAnimation(ranim)
        hub_id.startAnimation(lanim)
        handler= Handler()
        handler.postDelayed({
            val intent= Intent(this,MainActivity::class.java)
            startActivity(intent)
            finish()
        },3000)
    }
}