package com.example.imccalcapp.view

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.imccalcapp.R
import com.example.imccalcapp.utils.converteDataParaPortuguesBrasil

import java.time.LocalDate

class PesoActivity : AppCompatActivity() {
    lateinit var  tvDataPesagem: TextView
    lateinit var  buttonRegistrarPeso: Button
    lateinit var  editNovoPeso: EditText
    lateinit var  spinnerAtividades: Spinner

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.pesagemactivity2)
        supportActionBar!!.hide()

        tvDataPesagem = findViewById(R.id.tv_data_pesagem)
        buttonRegistrarPeso = findViewById(R.id.button_registrar_peso)
        editNovoPeso = findViewById(R.id.edit_novo_peso)
        spinnerAtividades = findViewById(R.id.spinner_atividades)

        tvDataPesagem.text = converteDataParaPortuguesBrasil(LocalDate.now())

        buttonRegistrarPeso.setOnClickListener{
            gravarPeso()
        }
    }

    private fun gravarPeso() {
        val arquivo = getSharedPreferences("usuario", MODE_PRIVATE)

        val editor = arquivo.edit()

        // ** Obter os dados já inseridos

        val peso = arquivo.getString("peso", "")
        val dataPesagem = arquivo.getString("data_pesagem", "")


        editor.putString("data_pesagem","$dataPesagem; ${LocalDate.now()}")
        editor.putString("peso", "$peso; ${editNovoPeso.text}")
        editor.putInt("nivel_de_atividade", spinnerAtividades.selectedItemPosition)
        editor.commit()
    }
}