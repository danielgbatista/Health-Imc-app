package com.example.imccalcapp.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.cardview.widget.CardView
import com.example.imccalcapp.R
import com.example.imccalcapp.utils.calcularIdade

class DashBoardActivity : AppCompatActivity() {
    //Declarando textView's com inicialização atrasada
    lateinit var tvNome: TextView
    lateinit var tvProfissao: TextView
    lateinit var tvAltura: TextView
    lateinit var tvIdade: TextView
    lateinit var crdPesarAgora: CardView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dash_board)
        supportActionBar!!.hide()

        tvNome = findViewById(R.id.text_nome)
        tvProfissao = findViewById(R.id.text_profissao)
        tvAltura = findViewById(R.id.text_altura)
        tvIdade = findViewById(R.id.text_idade)
        crdPesarAgora =  findViewById(R.id.card_pesar_agora)



        preencherDashBoard()


        crdPesarAgora.setOnClickListener {
            val abrirPesagem = Intent(this, PesoActivity::class.java)

            startActivity(abrirPesagem)
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