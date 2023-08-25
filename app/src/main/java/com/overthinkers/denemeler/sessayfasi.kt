package com.overthinkers.denemeler

import android.content.Context
import android.media.MediaPlayer
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class sessayfasi : AppCompatActivity()
{
    private lateinit var sestext: TextView
    var muzik:MediaPlayer?=null
    var tussesi:MediaPlayer?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.decorView.systemUiVisibility=View.SYSTEM_UI_FLAG_FULLSCREEN or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY or View.SYSTEM_UI_FLAG_LAYOUT_STABLE or  View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_FULLSCREEN
        setContentView(R.layout.sessayfasi)
    }

    fun tussesi()
    {
        var sharedPreferences = getSharedPreferences("systemodu", Context.MODE_PRIVATE)
        var ses = sharedPreferences.getString("ses", "hata")
        if (ses=="acik")
        {
            durdur()
            if(tussesi==null)
            {
                tussesi=MediaPlayer.create(this,R.raw.klavyeses)
                tussesi?.start()
            }
        }
    }

    fun durdur()
    {
        if (tussesi!==null)
        {
            tussesi?.stop()
            tussesi?.reset()
            tussesi?.release()
            tussesi=null
        }
    }

    fun ses1(view: View)
    {
        tussesi()
    }

    fun ses2(view: View)
    {
        tussesi()
    }

    fun ses3(view: View)
    {
        tussesi()
    }

    fun ses4(view: View)
    {
        durdur()
    }

    fun basla (view:View)
    {
        if (muzik == null)
        {
            muzik=MediaPlayer.create(this,R.raw.sarki)
            muzik?.start()
            sestext.textSize=20f
            sestext.setText("oynatılıyor...")
        }
    }

    fun dur (view:View)
    {
        if (muzik!==null)
        {
            muzik?.stop()
            muzik?.reset()
            muzik?.release()
            muzik=null
        sestext.textSize=20f
        sestext.setText("durdurulup sıfırlandı")
        }
    }

    override fun onPause()
    {
        super.onPause()
        if (muzik!==null)
        {
            muzik?.pause()
        }
    }

    override fun onResume() {
        super.onResume()
        if (muzik!==null)
        {
            muzik?.start()
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        overridePendingTransition(R.anim.anim,R.anim.anim2)
    }
}