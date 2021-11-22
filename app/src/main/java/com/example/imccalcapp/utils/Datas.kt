package com.example.imccalcapp.utils

    import android.util.Log
    import java.text.SimpleDateFormat
    import java.time.LocalDate
    import java.time.Period
    import java.util.*

fun calcularIdade(dataNascimento: String): Int{
        //obter a data atual
        val hoje = LocalDate.now()
        //21/05/1999 - 1999/05/21
    Log.i("xpto", hoje.toString())
        // converte a data nascimento que é string
        //em localDate
        val data = dataNascimento.split("-")

        Log.i("xpto", data.get(0))
        Log.i("xpto", data.get(1))
        Log.i("xpto", data.get(2))

        val nascimento = LocalDate.of(data.get(2).toInt(),
            data.get(1).toInt(),
            data.get(0).toInt())

        val idade = Period.between(nascimento, hoje).years

    Log.i("xpto", idade.toString())
        return 0
}