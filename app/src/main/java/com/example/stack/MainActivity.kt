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


        binding.text.text = randomItems()

        binding.retryButton.setOnClickListener {
            binding.text.text = randomItems()
        }
    }

    private fun randomItems(): String {
        val todo = listOf(
            "Advanced Programming in the Unix Environment",
            "Alice's Adventures in Wonderland",
            "Android Programming",
            "Breaking Bad",
            "Computer Networking",
            "Dinosaur Brains",
            "Friends",
            "GNU Emacs Manual",
            "graphviz",
            "Happier",
            "LaTeX",
            "Leetcode",
            "Operating Systems",
            "Pro Git",
            // "TCP/IP Protocol Suite",
            "The Standard C Library",
            "Wikipedia",
            "日日之食",
            "百年孤独",
        )
        var weightMap = todo.associateWith { 5 }.toMutableMap()
        weightMap["Breaking Bad"] = 2;
        weightMap["GNU Emacs Manual"] = 2;
        weightMap["graphviz"] = 2;
        weightMap["Friends"] = 3;
        weightMap["Pro Git"] = 3;

        val list = weightMap.entries.toList().map { (k, v) -> List(v) { k } }.flatten()

        return list.shuffled().toSet().take(5).joinToString(separator = "\n\n")
    }
}
