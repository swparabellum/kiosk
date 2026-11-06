package com.example.kiosk

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.kiosk.databinding.ActivityAdminModeBinding

class AdminmodeActivity : AppCompatActivity() {
    private lateinit var adminBinding: ActivityAdminModeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        adminBinding = ActivityAdminModeBinding.inflate(layoutInflater)
        setContentView(adminBinding.root)
    }
}