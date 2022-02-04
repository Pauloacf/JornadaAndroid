package com.example.jornada_android_introducao

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Adicionar um Listener ao botão
        // 1 - Pegar o botão
        // 2 - Adicionar o listener

        val btEnviar = findViewById<Button>(R.id.btEnviar)
        val tvResultado = findViewById<TextView>(R.id.tvResultado)
        val etName = findViewById<EditText>(R.id.etName)

        btEnviar.setOnClickListener {
            // Dentro das chaves, o código que escrevemos será executado apenas
            // quando o botão for clicado
            val name = etName.text.toString()

            if(name.isNotBlank()) {
                tvResultado.text = name
            }
            else {
                etName.error = "Digite um nome válido"
            }
        }
        // Funcionamento para abrir nova tela
        val btAbrirNovaTela = findViewById<Button>(R.id.btAbrirNovaTela)

        // Sempre que o botão for clicado
        btAbrirNovaTela.setOnClickListener {
            // Código será executado quando o botão for clicado
            // Para abrir uma nova tela, registramos a intenção de fazer isso
            // Intenção no Android = Intent
            val intentAbrirNovaTela = Intent(this, ResultadoActivity::class.java)

            intentAbrirNovaTela.putExtra("NOME_DIGITADO", etName.text.toString())
            // Registramos a intent
            startActivity(intentAbrirNovaTela)
        }
    }
}