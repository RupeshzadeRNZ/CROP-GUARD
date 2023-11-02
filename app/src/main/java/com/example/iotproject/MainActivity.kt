package com.example.iotproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val Controller = findViewById<Button>(R.id.controller)
        val Analyzer = findViewById<Button>(R.id.analyzer)
        val About = findViewById<Button>(R.id.about)

        Controller.setOnClickListener {
            val intent = Intent(this@MainActivity,ControllerActivity::class.java)
            startActivity(intent)
        }
        Analyzer.setOnClickListener {
            val intent = Intent(this@MainActivity,AnalyzerActivity::class.java)
            startActivity(intent)
        }
        About.setOnClickListener {
            val intent = Intent(this@MainActivity,AboutActivity::class.java)
            startActivity(intent)
        }

    }
}