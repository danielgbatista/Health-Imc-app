package com.example.imccalcapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.cardview.widget.CardView
import com.example.imccalcapp.utils.calcularIdade

class DashBoardActivity : AppCompatActivity() {
    //Declarando textView's com inicialização atrasada
    lateinit var tvNome: TextView
    lateinit var tvProfissao: TextView
    lateinit var tvAltura: TextView
    lateinit var tvIdade: TextView
    lateinit var rlPesar: RelativeLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dash_board)
        supportActionBar!!.hide()

        tvNome = findViewById(R.id.text_nome)
        tvProfissao = findViewById(R.id.text_profissao)
        tvAltura = findViewById(R.id.text_altura)
        tvIdade = findViewById(R.id.text_idade)
        rlPesar =  findViewById(R.id.pesar_agora)



        preencherDashBoard()

        rlPesar.setOnClickListener {
            val abrirPeso = Intent(this, PesoActivity::class.java)
            startActivity(abrirPeso)
        }
    }
    private fun preencherDashBoard(){
        //abrindo arquivo sharedPreferences usuario
        val arquivo = getSharedPreferences("usuario", MODE_PRIVATE)
        val dataNascimento = arquivo.getString("nascimento", "").toString()

        //recebendo valores dos textView's
        tvNome.text = arquivo.getString("nome","")
        tvProfissao.text = arquivo.getString("profissao", "--")
        tvAltura.text = arquivo.getFloat("altura", 0.0f).toString()
        tvIdade.text = calcularIdade(dataNascimento).toString()


    }
}