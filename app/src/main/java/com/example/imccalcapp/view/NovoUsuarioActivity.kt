package com.example.imccalcapp.view

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import android.widget.RadioButton
import android.widget.Toast
import com.example.imccalcapp.R
import java.util.*

class NovoUsuarioActivity : AppCompatActivity() {
    // Criando objeto do tipo EditText
    lateinit var editNome: EditText
    lateinit var editEmail: EditText
    lateinit var editSenha: EditText
    lateinit var editProfissao: EditText
    lateinit var editAltura: EditText
    lateinit var editDataNascimento: EditText
    lateinit var radioFeminio: RadioButton
    lateinit var radioMasculino: RadioButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_novo_usuario)

        editNome =findViewById(R.id.edit_nome)
        editEmail =findViewById(R.id.edit_email)
        editSenha =findViewById(R.id.edit_senha)
        editProfissao=findViewById(R.id.edit_profissao)
        editAltura =findViewById(R.id.edit_altura)
        editDataNascimento =findViewById(R.id.edit_data)
        radioFeminio =findViewById(R.id.radio_feminino)
        radioMasculino =findViewById(R.id.radio_masculino)

        supportActionBar!!.title = "Nova Conta"



        //Colocar um listener de click no edittext data
        //para abrir o calendário (DatePicker)
        editDataNascimento.setOnClickListener {
            criarDatePicker()
        }
    }
    fun criarDatePicker(){
        // Criar um calendário
        //Obter data atual
        val calendario = Calendar.getInstance()
        val dia = calendario.get(Calendar.DAY_OF_MONTH)
        val mes = calendario.get(Calendar.MONTH)
        val ano = calendario.get(Calendar.YEAR)
        val datePicker = DatePickerDialog(this,
                DatePickerDialog.OnDateSetListener{ view, _ano, _mes, _dia ->

                    var mesReal = _mes + 1
                    var diaString = "$_dia"
                    var mesString = "$mesReal"

                    if(mesReal < 10){
                        mesString = "0$mesReal"
                    }
                    if (_dia < 10){
                        diaString = "0$_dia"
                    }

                    Log.i("xxxx", "$diaString-$mesString-$_ano")
                    editDataNascimento.setText("$diaString-$mesString-$ano")

                }, ano, mes, dia)

        datePicker.show()
    }
    //Método que carrega o menu
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        //método para inflar o menu
        menuInflater.inflate(R.menu.menu_save, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(validarCampos()){
            //gravar dados com sharedPreferences (nome e modo)
            //criando ou abrindo arquivo xml(caso já exista) chamado usuário
            val arquivo = getSharedPreferences("usuario", MODE_PRIVATE)
            //chamando edit() para editar arquivo
            val editor = arquivo.edit()
            //recebendo dados no arquivo
            editor.putString("email", editEmail.text.toString())
            editor.putString("senha", editSenha.text.toString())
            editor.putString("nome", editNome.text.toString())
            editor.putString("profissao", editProfissao.text.toString())
            editor.putFloat("altura", editAltura.text.toString().toFloat())
            editor.putString("nascimento", editDataNascimento.text.toString())
            editor.putString("sexo", if(radioMasculino.isChecked) "M" else "F")

            //gravando
            editor.apply()

            Toast.makeText(this, "Usuário cadastrado com sucesso!!", Toast.LENGTH_SHORT).show()


            //encerrando activity
            finish()
        }
        else{
            //grava nada!!
        }
        return true
    }
    //criando função para validar campos (visibilidade, nome,  tipo retorno)
    private fun validarCampos() : Boolean{
        var valido = true
        //se estiver vazio isEmpty(retorna true ou false)
        if(editEmail.text.isEmpty()){
            editEmail.error = "Por favor insira seu E-mail"
            valido = false
        }
        else if(editSenha.text.isEmpty()){
            editSenha.error = "Senha obrigatótia"
            valido = false
        }
        else if(editNome.text.isEmpty()){
            editNome.error = "Nome obrigatório"
            valido = false

        }
        else if(editProfissao.text.isEmpty()){
            editProfissao.error = "Profissao Obrigatória"
            valido = false
        }
        return valido
    }
}