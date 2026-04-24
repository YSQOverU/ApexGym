package com.example.apexgym

import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class ReportesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reportes)

        // --- EL BOTÓN DE REGRESO ---
        findViewById<ImageButton>(R.id.btnRegresarReportes).setOnClickListener {
            finish()
        }
    }
}