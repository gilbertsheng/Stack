package com.example.stack

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.stack.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val todo = listOf(
            "Android", "APUE", "Dinosaur", "English", "Gatsby",
            "Happier", "IETLS", "Japanese", "Leetcode", "Networking",
            "OSTEP", "Recipe", "Solitude", "stdlib", "TCP/IP",
            "Wikipedia"
        )
        val text = todo.shuffled().take(5).joinToString(separator = "\n\n")
        binding.text.text = text
    }
}
