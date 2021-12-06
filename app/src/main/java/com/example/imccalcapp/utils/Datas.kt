package com.example.imccalcapp.utils

    import android.text.format.DateFormat
    import android.util.Log
    import java.text.SimpleDateFormat
    import java.time.LocalDate
    import java.time.Period
    import java.time.format.DateTimeFormatter
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

fun converteDataParaPortuguesBrasil(dataAtual: LocalDate): String {

    val formatoBrasil = DateTimeFormatter.ofPattern("dd/MM/yyyy")

    val dataBrasil =  dataAtual.format(formatoBrasil)

    return dataBrasil.toString()

}