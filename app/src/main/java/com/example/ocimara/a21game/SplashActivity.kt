package com.example.ocimara.a21game

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.animation.AnimationUtils
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        carregar()

    }

    fun carregar(){
        val animacao = AnimationUtils.loadAnimation(this, R.anim.animacao_splash)

        ivLogo.clearAnimation()
        ivLogo.startAnimation(animacao)

        //tread que espera 3 segundos e depois redireciona
        Handler().postDelayed({

            // isso é para mandar para outra tela,
            val intent = Intent(this@SplashActivity,MainActivity::class.java)

            //vai para a teça
            startActivity(intent)

            this@SplashActivity.finish()

        },3000)

    }
}
