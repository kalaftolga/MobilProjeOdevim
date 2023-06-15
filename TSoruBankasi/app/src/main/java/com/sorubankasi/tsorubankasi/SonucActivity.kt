package com.sorubankasi.tsorubankasi

import android.app.Instrumentation.ActivityResult
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sorubankasi.tsorubankasi.databinding.ActivityMainBinding
import com.sorubankasi.tsorubankasi.databinding.ActivitySonucBinding

class SonucActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySonucBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_sonuc)

        binding = ActivitySonucBinding.inflate(layoutInflater)
        val gorunum = binding.root
        setContentView(gorunum)

        val skor = intent.getIntExtra("DOGRU_CEVAP_SAYIM", 0)
        binding.sonucetiket.text = getString(R.string.sonucskor,skor)

        binding.yenidendenebtn.setOnClickListener{
            startActivity(Intent(this@SonucActivity, MainActivity::class.java))
        }
    }
}