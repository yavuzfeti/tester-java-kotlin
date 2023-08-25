package com.overthinkers.denemeler
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide

class ikili : AppCompatActivity() {

    private lateinit var oyna: com.airbnb.lottie.LottieAnimationView
    private lateinit var lottie: com.airbnb.lottie.LottieAnimationView
    private lateinit var exit: com.airbnb.lottie.LottieAnimationView
    private lateinit var renk: com.airbnb.lottie.LottieAnimationView
    private lateinit var ses: com.airbnb.lottie.LottieAnimationView
    private lateinit var ok: com.airbnb.lottie.LottieAnimationView
    private lateinit var asagi: com.airbnb.lottie.LottieAnimationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.decorView.systemUiVisibility=View.SYSTEM_UI_FLAG_FULLSCREEN or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY or View.SYSTEM_UI_FLAG_LAYOUT_STABLE or  View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_FULLSCREEN
        setContentView(R.layout.birinci)
        oyna.setAnimation("oyna.json")
        oyna.playAnimation()
        val imageView: ImageView = findViewById(R.id.gifoynat)
        Glide.with(this).load(R.drawable.giphy).into(imageView)
        lottie.setAnimation("ek.json")
        lottie.playAnimation()
        val imageView2: ImageView = findViewById(R.id.perspektif)
        Glide.with(this).load(R.drawable.perspektif).into(imageView2)
    }

    fun birinci(view: View)
    {
        setContentView(R.layout.birinci)
    }

    fun ikinci(view: View)
    {
        setContentView(R.layout.ikinci)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        overridePendingTransition(R.anim.anim,R.anim.anim2)
    }

    fun exit (view: View)
    {
        exit.setAnimation("exit.json")
        exit.playAnimation()
        onBackPressed()
    }

    fun renk (view: View)
    {
        renk.setAnimation("renk.json")
        renk.playAnimation()
    }

    fun ses (view: View)
    {
        ses.setAnimation("ses.json")
        ses.playAnimation()
    }

    fun ok (view: View)
    {
        ok.setAnimation("yukariokyesil.json")
        ok.playAnimation()
    }

    fun asagi (view: View)
    {
        asagi.setAnimation("asagiokyesil.json")
        asagi.playAnimation()
    }
}