package com.chattymin.kakaologintest

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.chattymin.kakaologintest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
