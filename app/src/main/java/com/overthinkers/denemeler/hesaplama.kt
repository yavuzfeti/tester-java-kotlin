package com.overthinkers.denemeler
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class hesaplama : AppCompatActivity() {

    private lateinit var islem: TextView
    private lateinit var sonuc: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.decorView.systemUiVisibility =
            View.SYSTEM_UI_FLAG_FULLSCREEN or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY or View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_FULLSCREEN
        setContentView(R.layout.hesaplama)
    }


    val ilksayi="0"
    var ilkislem="bos"
    var ikinciislem="bos"
    //var ucuncuislem="bos"
    //var dorduncuislem="bos"
    //var besinciislem="bos"


    fun sonraki()
    {
        var islemearti=islem.text.indexOf("+")
        var islemeeksi=islem.text.indexOf("-")
        var islemdizisi=islem.text.split("+","-")
        var sonucu=0
        if (islemearti!=-1 || islemeeksi!=-1)
        {
            if (ilkislem=="+")
            {
                sonucu=islemdizisi[0].toInt()+islemdizisi[1].toInt()
            }
            else if (ilkislem=="-")
            {
                sonucu=islemdizisi[0].toInt()-islemdizisi[1].toInt()
            }
            if (ikinciislem=="+")
            {
                sonucu=sonucu+islemdizisi[2].toInt()
            }
            else if (ikinciislem=="-")
            {
                sonucu=sonucu-islemdizisi[2].toInt()
            }

        }
        if (islemearti==-1 && islemeeksi==-1)
        {
            sonucu=islem.text.toString().toInt()
        }
        sonuc.setText(sonucu.toString())
    }




    fun arti (view: View)
    {
        var islemearti=islem.text.indexOf("+")
        var islemeeksi=islem.text.indexOf("-")
        if (islemearti==-1 && islemeeksi==-1)
        {
            ilkislem="+"
        }
        else if (islemearti!=-1 || islemeeksi!=-1)
        {
            ikinciislem="+"
        }
        if (islem.text!=ilksayi && islem.text.substring(islem.length()-1,islem.length())!="+" && islem.text.substring(islem.length()-1,islem.length())!="-")
        {
            islem.setText("${islem.text}+")
        }
        else if (islem.text.substring(islem.length()-1,islem.length())=="-")
        {
            islem.setText("${islem.text.substring(0,islem.length()-1)}+")
        }
    }

    fun eksi (view: View)
    {
        var islemearti=islem.text.indexOf("+")
        var islemeeksi=islem.text.indexOf("-")
        if (islemearti==-1 && islemeeksi==-1)
        {
            ilkislem="-"
        }
        else if (islemearti!=-1 || islemeeksi!=-1)
        {
            ikinciislem="-"
        }
        if (islem.text!=ilksayi && islem.text.substring(islem.length()-1,islem.length())!="+" && islem.text.substring(islem.length()-1,islem.length())!="-")
        {
            islem.setText("${islem.text}-")
        }
        else if (islem.text.substring(islem.length()-1,islem.length())=="+")
        {
            islem.setText("${islem.text.substring(0,islem.length()-1)}-")
        }
    }

    fun onceki()
    {
        if (islem.text==ilksayi)
        {
            islem.setText("")
        }
    }

    fun esittir (view: View)
    {
        islem.setText(sonuc.text)
        sonuc.setText(ilksayi)
    }

    fun temizle(view: View)
    {
        islem.setText(ilksayi)
        sonuc.setText(ilksayi)
    }

    fun silme(view: View)
    {
        if (islem.length()>1 && islem.text!=ilksayi)
        {
            islem.setText("${islem.text.substring(0,islem.length()-1)}")
            if (islem.text.substring(islem.length()-1,islem.length())!="+" && islem.text.substring(islem.length()-1,islem.length())!="-")
            {
                sonraki()
            }
            else
            {
                sonuc.setText("${islem.text.substring(0,islem.length()-1)}")
                ikinciislem="bos"
                ilkislem="bos"
            }
        }
        else
        {
            islem.setText(ilksayi)
            sonuc.setText(ilksayi)
        }
    }

    fun bir (view: View)
    {
        onceki()
        islem.setText("${islem.text}1")
        sonraki()
    }

    fun iki (view: View)
    {
        onceki()
        islem.setText("${islem.text}2")
        sonraki()
    }

    fun uc (view: View)
    {
        onceki()
        islem.setText("${islem.text}3")
        sonraki()
    }

    fun dort (view: View)
    {
        onceki()
        islem.setText("${islem.text}4")
        sonraki()
    }

    fun bes (view: View)
    {
        onceki()
        islem.setText("${islem.text}5")
        sonraki()
    }

    fun alti (view: View)
    {
        onceki()
        islem.setText("${islem.text}6")
        sonraki()
    }

    fun yedi (view: View)
    {
        onceki()
        islem.setText("${islem.text}7")
        sonraki()
    }

    fun sekiz (view: View)
    {
        onceki()
        islem.setText("${islem.text}8")
        sonraki()
    }

    fun dokuz (view: View)
    {
        onceki()
        islem.setText("${islem.text}9")
        sonraki()
    }

    fun sifir (view: View)
    {
        onceki()
        islem.setText("${islem.text}0")
        sonraki()
    }

    override fun onBackPressed()
    {
        super.onBackPressed()
        overridePendingTransition(R.anim.anim, R.anim.anim2)
    }
}