package com.overthinkers.denemeler

import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.view.View
import android.widget.Switch
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity()
{
    var arkamuzik:MediaPlayer?=null
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        window.decorView.systemUiVisibility=View.SYSTEM_UI_FLAG_FULLSCREEN or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY or View.SYSTEM_UI_FLAG_LAYOUT_STABLE or  View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_FULLSCREEN
        setContentView(R.layout.activity_main)
        var sharedPreferences = getSharedPreferences("systemodu", Context.MODE_PRIVATE)
        //muzik açıp kapatma
        var muzik = sharedPreferences.getString("muzik", "hata")
        val btn = findViewById<Switch>(R.id.muziksvic)
        if (muzik != "kapali")
        {
            btn.isChecked = true
            sharedPreferences.edit().putString("muzik", "acik").apply()
            if(arkamuzik==null)
            {
                arkamuzik=MediaPlayer.create(this,R.raw.sarki)
                arkamuzik?.start()
            }
        }
        btn.setOnCheckedChangeListener { _, isChecked ->
            if (btn.isChecked)
            {
                sharedPreferences.edit().putString("muzik", "acik").apply()
                if(arkamuzik==null)
                {
                    arkamuzik=MediaPlayer.create(this,R.raw.sarki)
                    arkamuzik?.start()
                }
            }
            else
            {
                sharedPreferences.edit().putString("muzik", "kapali").apply()
                if (arkamuzik!==null)
                {
                    arkamuzik?.stop()
                    arkamuzik?.reset()
                    arkamuzik?.release()
                    arkamuzik=null
                }
            }
        }


        //ses açık kapalı ayarı
        var ses = sharedPreferences.getString("ses", "hata")
        val btn2 = findViewById<Switch>(R.id.sessvic)
        if (ses != "kapali")
        {
            btn2.isChecked = true
            sharedPreferences.edit().putString("ses", "acik").apply()
        }
        btn2.setOnCheckedChangeListener { _, isChecked ->
            if (btn2.isChecked)
            {
                sharedPreferences.edit().putString("ses", "acik").apply()
            }
            else
            {
                sharedPreferences.edit().putString("ses", "kapali").apply()
            }
        }
    }

    override fun onResume()
    {
        super.onResume()
        if(arkamuzik!==null)
        {
            arkamuzik?.start()
        }
    }

    override fun onPause()
    {
        super.onPause()
        if (arkamuzik!==null)
        {
            arkamuzik?.pause()
        }

    }

    fun music (view: View)
    {
        val intent=Intent(this,music::class.java)
        startActivity(intent)
        overridePendingTransition(R.anim.anim,R.anim.anim2)
        finish()
    }

    fun hesaplama(view: View)
    {
        val intent=Intent(this,hesaplama::class.java)
        startActivity(intent)
        overridePendingTransition(R.anim.anim,R.anim.anim2)
    }

    fun buton(view: View)
    {
        val intent = Intent(this, buton::class.java)
        startActivity(intent)
        overridePendingTransition(R.anim.anim,R.anim.anim2)
    }

    fun klavye (view: View)
    {
        val intent = Intent(this, klavye::class.java)
        startActivity(intent)
        overridePendingTransition(R.anim.anim,R.anim.anim2)
    }

    fun kredisayfasi(view: View)
    {
        val intent=Intent(this,kredi::class.java)
        startActivity(intent)
        overridePendingTransition(R.anim.anim,R.anim.anim2)
    }

    fun sessayfasi(view: View)
    {
        val intent=Intent(this,sessayfasi::class.java)
        startActivity(intent)
        overridePendingTransition(R.anim.anim,R.anim.anim2)
    }

    fun ikili (view: View)
    {
        val intent = Intent(this, ikili::class.java)
        startActivity(intent)
        overridePendingTransition(R.anim.anim, R.anim.anim2)
    }

    fun splash (view: View)
    {
        val intent=Intent(this,splash::class.java)
        startActivity(intent)
        overridePendingTransition(R.anim.anim,R.anim.anim2)
        finish()
    }
}


