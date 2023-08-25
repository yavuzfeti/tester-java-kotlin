package com.overthinkers.denemeler
import android.content.Context
import android.media.MediaPlayer
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity


class buton : AppCompatActivity() {
    private lateinit var resim: ImageView
    private lateinit var resim2: ImageView
    private lateinit var resim3: ImageView
    private lateinit var resim4: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.decorView.systemUiVisibility =
            View.SYSTEM_UI_FLAG_FULLSCREEN or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY or View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_FULLSCREEN
        setContentView(R.layout.buton)
    }


    var klavyesesi: MediaPlayer?=null
    fun ses()
    {
        var sharedPreferences = getSharedPreferences("systemodu", Context.MODE_PRIVATE)
        var ses = sharedPreferences.getString("ses", "hata")
        if (ses=="acik")
        {
            if (klavyesesi!==null)
            {
                klavyesesi?.stop()
                klavyesesi?.reset()
                klavyesesi?.release()
                klavyesesi=null
            }
            if(klavyesesi==null)
            {
                klavyesesi= MediaPlayer.create(this,R.raw.klavyeses)
                klavyesesi?.start()
            }
        }
    }


    fun resimbuton(view: View)
    {
        ses()
        resim.setBackgroundResource(R.drawable.buton2)
        resim.animate().apply {
            duration=200
            alpha(0f)}.withEndAction {
            resim.setBackgroundResource(R.drawable.buton)
            resim.animate().apply {
                duration=200
                alpha(1f)}}
    }

    fun resimbuton2(view: View)
    {
        ses()
        resim2.animate().apply {
            duration=100
            alpha(0f)}.withEndAction {
            resim2.animate().apply {
            duration=100
            alpha(1f)}}
    }

    fun resimbuton3(view: View)
    {
        ses()
        resim3.animate().apply {
            resim3.setBackgroundResource(R.drawable.buton2)
            duration=250
            alpha(1f)

        }.withEndAction{
            resim3.animate().apply {
                resim3.setBackgroundResource(R.drawable.buton)
            }.start()
        }
    }

    fun resimbuton4(view: View)
    {
        ses()
        resim4.animate().apply {
            duration=150
            alpha(0f)}.withEndAction {
            resim4.setBackgroundResource(R.drawable.buton2)
            resim4.animate().apply {
                duration=150
                alpha(1f)}}
    }

        override fun onBackPressed()
        {
            super.onBackPressed()
            overridePendingTransition(R.anim.anim, R.anim.anim2)
        }
    }
