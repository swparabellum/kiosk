package com.example.kiosk

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.kiosk.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        val mainView = binding.root
        setContentView(mainView)
        ViewCompat.setOnApplyWindowInsetsListener(mainView) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.composeCategoryTabRow.setContent {
            CategoryTabRow { _, category ->
                Toast.makeText(this, "선택된 카테고리: $category", Toast.LENGTH_SHORT).show()
            }
        }

        binding.composeBeverageGrid.setContent {
            BeverageVerticalGrid { item ->
                Toast.makeText(this, "선택된 음료: ${item.name}", Toast.LENGTH_SHORT).show()
            }
        }
    }
}