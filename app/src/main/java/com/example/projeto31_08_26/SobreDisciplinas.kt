package com.example.projeto31_08_26

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DisciplinasActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_disciplinas)

        val btnVoltar = findViewById<Button>(R.id.btnVoltar)
        btnVoltar.setOnClickListener {
            finish()
        }

      val disciplinas = listOf<TextView>(
        findViewById(R.id.disciplinaProgramacao),
         findViewById(R.id.disciplinaBancoDados),
         findViewById(R.id.disciplinaEngSoftware),
            findViewById(R.id.disciplinaDesenvWeb),
            findViewById(R.id.disciplinaDesenvMobile),
            findViewById(R.id.disciplinaIA)
        )

        
        for (disciplina in disciplinas) {
            disciplina.setOnClickListener {
                abrirDetalhes(disciplina.text.toString())
            }
        }
    }

    private fun abrirDetalhes(nomeDisciplina: String) {
        
        val intent = Intent(this, DetalhesDisciplinaActivity::class.java)
        intent.putExtra("NOME_DISCIPLINA", nomeDisciplina)
        startActivity(intent)
    }
}
