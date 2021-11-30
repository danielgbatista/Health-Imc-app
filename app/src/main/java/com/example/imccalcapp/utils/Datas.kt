package com.example.imccalcapp.utils

    import android.util.Log
    import java.text.SimpleDateFormat
    import java.time.LocalDate
    import java.time.Period
    import java.util.*

fun calcularIdade(dataNascimento: String): Int{

        //obter a data atual
        val hoje = LocalDate.now()

        // converte a data nascimento que é string
        //em localDate
        val data = dataNascimento.split("-")


        val nascimento = LocalDate.of(data.get(2).toInt(),data.get(1).toInt(),data.get(0).toInt())

        val idade = Period.between(nascimento, hoje).years

        return idade
}