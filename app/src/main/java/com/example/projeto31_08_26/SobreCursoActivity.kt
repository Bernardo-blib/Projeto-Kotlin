package com.example.projeto31_08_26

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class SobreCursoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sobre_curso)

        val btnVoltar = findViewById<Button>(R.id.btnVoltar)
        val btnDisciplinas = findViewById<Button>(R.id.btnDisciplinas)

        btnVoltar.setOnClickListener {
            finish()
        }

        btnDisciplinas.setOnClickListener {
            val intent = Intent(this, DisciplinasActivity::class.java)
            startActivity(intent)
        }
    }
}