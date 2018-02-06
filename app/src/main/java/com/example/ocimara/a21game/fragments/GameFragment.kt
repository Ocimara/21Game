package com.example.ocimara.a21game.fragments

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.content.ContextCompat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.example.ocimara.a21game.EstorouPontuacaoActivity
import com.example.ocimara.a21game.R
import com.example.ocimara.a21game.dao.CartaDAO
import com.example.ocimara.a21game.model.Carta
import kotlinx.android.synthetic.main.fragment_game.*
import java.util.*
import kotlin.collections.ArrayList

class GameFragment : Fragment() {

    val cartaDAO = CartaDAO()
    val gerador = Random()
    var cartas: MutableList<Carta> = ArrayList()

    lateinit var btRecomecar: Button
    lateinit var tvPontuacao: TextView


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        btProximaCarta.setOnClickListener({
            realizarJogada()

        })

    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view = inflater!!.inflate(R.layout.fragment_game, container, false)

        btRecomecar = view.findViewById(R.id.btRecomecar)
        tvPontuacao = view.findViewById(R.id.tvPontuacao)


        btRecomecar.setOnClickListener({
            iniciarPartida()
            return view
        })

        //return inflater!!.inflate(R.layout.fragment_game, container, false)
    }

    fun iniciarPartida() {
        tvPontuacao.setText("0")
        cartas = cartaDAO.getBaralho().toMutableList()
    }

    fun realizarJogada() {

        val posicaoCartaSeleciona = gerador.nextInt(cartas.size)
        val cartaSelecionada = cartas.get(posicaoCartaSeleciona)

        val pontuacaoAtualizada = tvPontuacao.text.toString().toInt() + cartaSelecionada.pontuacao
        tvPontuacao.text = pontuacaoAtualizada.toString()

        if(pontuacaoAtualizada > 21)
        {
            val intent = Intent(context, EstorouPontuacaoActivity::class.java)
            intent.putExtra("PONTUACAO",tvPontuacao.text.toString())
            startActivity(intent)
        }
        else
        {
            cartas.removeAt(posicaoCartaSeleciona)
            ivCarta.setImageDrawable(ContextCompat.getDrawable(context,cartaSelecionada.resourceId))
        }

    }

}

