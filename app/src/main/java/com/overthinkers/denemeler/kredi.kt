package com.overthinkers.denemeler

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class kredi : AppCompatActivity() {

    private lateinit var kreditext: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.decorView.systemUiVisibility=View.SYSTEM_UI_FLAG_FULLSCREEN or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY or View.SYSTEM_UI_FLAG_LAYOUT_STABLE or  View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_FULLSCREEN
        setContentView(R.layout.kredi)
        //gosterme
        var sharedPreferences0 = getSharedPreferences("ipuclari", Context.MODE_PRIVATE)
        var kredisayisison=sharedPreferences0.getInt("kredi",0)
        kreditext.setText(kredisayisison.toString())
    }

    override fun onRestart() {
        super.onRestart()
        var sharedPreferences0 = getSharedPreferences("ipuclari", Context.MODE_PRIVATE)
        var kredisayisison=sharedPreferences0.getInt("kredi",0)
        kreditext.setText(kredisayisison.toString())
    }

    fun arttir (view: View)
    {
        //arttırma
        var sharedPreferences0 = getSharedPreferences("ipuclari", Context.MODE_PRIVATE)
        var kredisayisiilk=sharedPreferences0.getInt("kredi",0)
        sharedPreferences0.edit().putInt("kredi",kredisayisiilk+1).apply()
        var kredisayisison=sharedPreferences0.getInt("kredi",0)
        kreditext.setText(kredisayisison.toString())
    }

    fun eksilt (view: View)
    {
        //eksiltme
        var sharedPreferences0 = getSharedPreferences("ipuclari", Context.MODE_PRIVATE)
        var kredisayisiilk=sharedPreferences0.getInt("kredi",0)
        if (kredisayisiilk>0)
        {
            sharedPreferences0.edit().putInt("kredi", kredisayisiilk - 1).apply()
            var kredisayisison=sharedPreferences0.getInt("kredi",0)
            kreditext.setText(kredisayisison.toString())
        }
        else
        {
            Toast.makeText(this, "eksi kredi olamaz", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        overridePendingTransition(R.anim.anim,R.anim.anim2)
    }
}