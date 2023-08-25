package com.overthinkers.denemeler

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class splash : AppCompatActivity() {
    private lateinit var logo_splash: com.airbnb.lottie.LottieAnimationView
    private val splashScreen=1500
    override fun onCreate(savedInstanceState: Bundle?) {
        logo_splash = findViewById(R.id.logo_splash)
        super.onCreate(savedInstanceState)
        window.decorView.systemUiVisibility=View.SYSTEM_UI_FLAG_FULLSCREEN or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY or View.SYSTEM_UI_FLAG_LAYOUT_STABLE or  View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_FULLSCREEN
        setContentView(R.layout.splash)
        logo_splash.setAnimation("logo_splash.json")
        logo_splash.playAnimation()
        Handler().postDelayed({
            val intent= Intent(this,MainActivity::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.anim,R.anim.anim2)
            finish()
        },splashScreen.toLong())
    }
}