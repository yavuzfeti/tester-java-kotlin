package com.overthinkers.denemeler


import android.content.Context
import android.media.MediaPlayer
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class klavye : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        window.decorView.systemUiVisibility=View.SYSTEM_UI_FLAG_FULLSCREEN or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY or View.SYSTEM_UI_FLAG_LAYOUT_STABLE or  View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_FULLSCREEN
        setContentView(R.layout.klavye)
    }

    override fun onBackPressed()
    {
        super.onBackPressed()
        overridePendingTransition(R.anim.anim,R.anim.anim2)
    }



    //KLAVYE

    //DEĞİŞKEN KISIM


    //TANIMLAMALAR

    val cevaptext: TextView
        get() = findViewById<TextView>(R.id.cevaptext)

    val ilkmetin=""

    var klavyesesi:MediaPlayer?=null

    var harf:Button?=null

    //İLK VE SON İŞLEM

    fun son()
    {
        if (cevaptext.text=="EVET")
        {
            cevaptext.setText("iyi güzel doğru cevap")
        }
        else if (cevaptext.length()>=20&&cevaptext.text!=ilkmetin)
        {
            cevaptext.setText("${cevaptext.text.substring(0,cevaptext.length()-1)}")
            Toast.makeText(this, "Maximum harf sınırı 20", Toast.LENGTH_SHORT).show()

        }
    }

    fun ilk()
    {
        ses()
        animasyon()
        if (cevaptext.text==ilkmetin)
        {
            cevaptext.setText("")
        }
    }

    //ANİMASYON VE SES

    fun animasyon()
    {
        if (harf!=null)
        {
            harf!!.animate().apply {
                duration = 100
                alpha(0f)
            }.withEndAction {
                harf!!.animate().apply {
                    duration = 100
                    alpha(1f)
                }
            }
        }
    }

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
                klavyesesi=MediaPlayer.create(this,R.raw.klavyeses)
                klavyesesi?.start()
            }
        }
    }

    //SİLME VE BOŞLUK

    fun sil(view: View)
    {
        ses()
        harf =findViewById(R.id.sil)
        animasyon()
        if (cevaptext.length()>1 && cevaptext.text!=ilkmetin)
        {
            cevaptext.setText("${cevaptext.text.substring(0,cevaptext.length()-1)}")
        }
        else
        {
            cevaptext.setText(ilkmetin)
        }
    }

    fun bosluk (view: View)
    {
        ses()
        harf =findViewById(R.id.bosluk)
        animasyon()
        if (cevaptext.length()>0 && cevaptext.text!=ilkmetin && cevaptext.text.substring(cevaptext.length()-1,cevaptext.length())!=" ")
        {
            cevaptext.setText("${cevaptext.text} ")
        }
        son()
    }

    //SABİT KISIM

    fun a (view: View)
    {
        harf =findViewById(R.id.a)
        ilk()
        cevaptext.setText("${cevaptext.text}A")
        son()
    }
    fun b (view: View)
    {
        harf =findViewById(R.id.b)
        ilk()
        cevaptext.setText("${cevaptext.text}B")
        son()
    }
    fun c (view: View)
    {
        harf =findViewById(R.id.c)
        ilk()
        cevaptext.setText("${cevaptext.text}C")
        son()
    }
    fun c2 (view: View)
    {
        harf =findViewById(R.id.c2)
        ilk()
        cevaptext.setText("${cevaptext.text}Ç")
        son()
    }
    fun d (view: View)
    {
        harf =findViewById(R.id.d)
        ilk()
        cevaptext.setText("${cevaptext.text}D")
        son()
    }
    fun e (view: View)
    {
        harf =findViewById(R.id.e)
        ilk()
        cevaptext.setText("${cevaptext.text}E")
        son()
    }
    fun f (view: View)
    {
        harf =findViewById(R.id.f)
        ilk()
        cevaptext.setText("${cevaptext.text}F")
        son()
    }
    fun g (view: View)
    {
        harf =findViewById(R.id.g)
        ilk()
        cevaptext.setText("${cevaptext.text}G")
        son()
    }
    fun g2 (view: View)
    {
        harf =findViewById(R.id.g2)
        ilk()
        cevaptext.setText("${cevaptext.text}Ğ")
        son()
    }
    fun h (view: View)
    {
        harf =findViewById(R.id.h)
        ilk()
        cevaptext.setText("${cevaptext.text}H")
        son()
    }
    fun i2 (view: View)
    {
        harf =findViewById(R.id.i2)
        ilk()
        cevaptext.setText("${cevaptext.text}I")
        son()
    }
    fun i (view: View)
    {
        harf =findViewById(R.id.i)
        ilk()
        cevaptext.setText("${cevaptext.text}İ")
        son()
    }
    fun j (view: View)
    {
        harf =findViewById(R.id.j)
        ilk()
        cevaptext.setText("${cevaptext.text}J")
        son()
    }
    fun k (view: View)
    {
        harf =findViewById(R.id.k)
        ilk()
        cevaptext.setText("${cevaptext.text}K")
        son()
    }
    fun l (view: View)
    {
        harf =findViewById(R.id.l)
        ilk()
        cevaptext.setText("${cevaptext.text}L")
        son()
    }
    fun m (view: View)
    {
        harf =findViewById(R.id.m)
        ilk()
        cevaptext.setText("${cevaptext.text}M")
        son()
    }
    fun n (view: View)
    {
        harf =findViewById(R.id.n)
        ilk()
        cevaptext.setText("${cevaptext.text}N")
        son()
    }
    fun o (view: View)
    {
        harf =findViewById(R.id.o)
        ilk()
        cevaptext.setText("${cevaptext.text}O")
        son()
    }
    fun o2 (view: View)
    {
        harf =findViewById(R.id.o2)
        ilk()
        cevaptext.setText("${cevaptext.text}Ö")
        son()
    }
    fun p (view: View)
    {
        harf =findViewById(R.id.p)
        ilk()
        cevaptext.setText("${cevaptext.text}P")
        son()
    }
    fun q (view: View)
    {
        harf =findViewById(R.id.q)
        ilk()
        cevaptext.setText("${cevaptext.text}Q")
        son()
    }
    fun r (view: View)
    {
        harf =findViewById(R.id.r)
        ilk()
        cevaptext.setText("${cevaptext.text}R")
        son()
    }
    fun s (view: View)
    {
        harf =findViewById(R.id.s)
        ilk()
        cevaptext.setText("${cevaptext.text}S")
        son()
    }
    fun s2 (view: View)
    {
        harf =findViewById(R.id.s2)
        ilk()
        cevaptext.setText("${cevaptext.text}Ş")
        son()
    }
    fun t (view: View)
    {
        harf =findViewById(R.id.t)
        ilk()
        cevaptext.setText("${cevaptext.text}T")
        son()

    }
    fun u (view: View)
    {
        harf =findViewById(R.id.u)
        ilk()
        cevaptext.setText("${cevaptext.text}U")
        son()
    }
    fun u2 (view: View)
    {
        harf =findViewById(R.id.u2)
        ilk()
        cevaptext.setText("${cevaptext.text}Ü")
        son()
    }
    fun v (view: View)
    {
        harf =findViewById(R.id.v)
        ilk()
        cevaptext.setText("${cevaptext.text}V")
        son()
    }
    fun w (view: View)
    {
        harf =findViewById(R.id.w)
        ilk()
        cevaptext.setText("${cevaptext.text}W")
        son()
    }
    fun x (view: View)
    {
        harf =findViewById(R.id.x)
        ilk()
        cevaptext.setText("${cevaptext.text}X")
        son()
    }
    fun y (view: View)
    {
        harf =findViewById(R.id.y)
        ilk()
        cevaptext.setText("${cevaptext.text}Y")
        son()
    }
    fun z (view: View)
    {
        harf =findViewById(R.id.z)
        ilk()
        cevaptext.setText("${cevaptext.text}Z")
        son()
    }
}