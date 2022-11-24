package com.example.personnal_project_heim

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.example.personnal_project_heim.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val rootView = binding.root
        setContentView(rootView)
       // setContentView(R.layout.activity_main)

      //  val helloWorldTextView = findViewById<TextView>(R.id.hello_word_text_view)
        Log.i("MainActivity", binding.helloWordTextView.text.toString())
    }
}