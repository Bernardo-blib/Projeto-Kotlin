package com.example.projeto31_08_26

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


data class DisciplinaInfo(
    val cargaHoraria: String,
    val modalidade: String,
    val professor: String,
    val preRequisito: String,
    val descricao: String
)

class DetalhesDisciplinaActivity : AppCompatActivity() {

    
    private val disciplinasInfo = mapOf(
        "Programação" to DisciplinaInfo(
            cargaHoraria = "80 horas",
            modalidade = "Presencial",
            professor = "Prof. Carlos Lima",
            preRequisito = "Nenhum",
            descricao = "Introdução à lógica de programação, variáveis, estruturas de decisão e repetição."
        ),
        "Banco de Dados" to DisciplinaInfo(
            cargaHoraria = "60 horas",
            modalidade = "Presencial",
            professor = "Profa. Ana Souza",
            preRequisito = "Programação",
            descricao = "Modelagem de dados, SQL e conceitos de bancos relacionais."
        ),
        "Engenharia de Software" to DisciplinaInfo(
            cargaHoraria = "70 horas",
            modalidade = "Online",
            professor = "Prof. Marcos Alves",
            preRequisito = "Programação",
            descricao = "Processos de desenvolvimento, requisitos, metodologias ágeis e testes de software."
        ),
        "Desenvolvimento Web" to DisciplinaInfo(
            cargaHoraria = "80 horas",
            modalidade = "Presencial",
            professor = "Profa. Beatriz Nunes",
            preRequisito = "Programação",
            descricao = "Desenvolvimento de páginas e sistemas web com HTML, CSS, JavaScript e frameworks."
        ),
        "Desenvolvimento Mobile" to DisciplinaInfo(
            cargaHoraria = "80 horas",
            modalidade = "Presencial",
            professor = "Prof. Leandro Melo",
            preRequisito = "Programação",
            descricao = "Nesta disciplina são estudados conceitos relacionados ao desenvolvimento de aplicativos com Kotlin e Android Studio."
        ),
        "Inteligência Artificial" to DisciplinaInfo(
            cargaHoraria = "60 horas",
            modalidade = "Online",
            professor = "Prof. Rafael Costa",
            preRequisito = "Programação e Banco de Dados",
            descricao = "Fundamentos de inteligência artificial, machine learning e aplicações práticas."
        )
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalhes_disciplina)

        .
        val nomeDisciplina = intent.getStringExtra("NOME_DISCIPLINA") ?: "Disciplina"

        
        val info = disciplinasInfo[nomeDisciplina] ?: DisciplinaInfo(
            cargaHoraria = "A definir",
            modalidade = "A definir",
            professor = "A definir",
            preRequisito = "Nenhum",
            descricao = "Descrição não cadastrada para esta disciplina."
        )

        val tvNome = findViewById<TextView>(R.id.tvNomeDisciplina)
        val tvCargaHoraria = findViewById<TextView>(R.id.tvCargaHoraria)
        val tvModalidade = findViewById<TextView>(R.id.tvModalidade)
        val tvProfessor = findViewById<TextView>(R.id.tvProfessor)
        val tvPreRequisito = findViewById<TextView>(R.id.tvPreRequisito)
        val tvDescricao = findViewById<TextView>(R.id.tvDescricao)

        tvNome.text = nomeDisciplina
        tvCargaHoraria.text = "Carga horária: ${info.cargaHoraria}"
        tvModalidade.text = "Modalidade: ${info.modalidade}"
        tvProfessor.text = "Professor: ${info.professor}"
        tvPreRequisito.text = "Pré-requisito: ${info.preRequisito}"
        tvDescricao.text = info.descricao

        val btnVoltar = findViewById<Button>(R.id.btnVoltarDetalhes)
        btnVoltar.setOnClickListener {
            finish() 
        }

        
        val btnCompartilhar = findViewById<Button>(R.id.btnCompartilhar)
        btnCompartilhar.setOnClickListener {
            val texto = """
                Disciplina: $nomeDisciplina
                Carga horária: ${info.cargaHoraria}
                Modalidade: ${info.modalidade}
                Professor: ${info.professor}
                Pré-requisito: ${info.preRequisito}
                Descrição: ${info.descricao}
            """.trimIndent()

            val intentCompartilhar = Intent(Intent.ACTION_SEND).apply {
                type = "text/plain"
                putExtra(Intent.EXTRA_SUBJECT, "Disciplina: $nomeDisciplina")
                putExtra(Intent.EXTRA_TEXT, texto)
            }
            startActivity(Intent.createChooser(intentCompartilhar, "Compartilhar disciplina via"))
        }
    }
}
