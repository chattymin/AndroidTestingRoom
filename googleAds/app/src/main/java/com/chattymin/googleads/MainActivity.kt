package com.chattymin.googleads

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.chattymin.googleads.databinding.ActivityMainBinding
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.MobileAds

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        MobileAds.initialize(this)

        val adRequest = AdRequest.Builder().build()
        binding.adView.loadAd(adRequest)
    }
}
