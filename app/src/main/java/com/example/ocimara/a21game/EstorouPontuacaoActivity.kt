package com.example.ocimara.a21game

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.airbnb.lottie.LottieAnimationView



class EstorouPontuacaoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_estorou_pontuacao)
        val animationView = findViewById<View>(R.id.animation_view) as LottieAnimationView
        animationView.setAnimation("emoji_tongue.json")
        animationView.loop(true)
        animationView.playAnimation()




    }
}
