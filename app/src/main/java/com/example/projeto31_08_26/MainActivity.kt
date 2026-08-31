package com.example.projeto31_08_26

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnConheca = findViewById<Button>(R.id.btnConheca)
        val btnDisciplinas = findViewById<Button>(R.id.btnDisciplinas)

        btnConheca.setOnClickListener {
            val intent = Intent(this, SobreCursoActivity::class.java)
            startActivity(intent)
        }

        btnDisciplinas.setOnClickListener {
            val intent = Intent(this, DisciplinasActivity::class.java)
            startActivity(intent)
        }
    }
}