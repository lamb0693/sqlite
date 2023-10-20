package com.example.chap17sqlite

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputBinding
import com.example.chap17sqlite.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
  lateinit var binding: ActivityMainBinding
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityMainBinding.inflate(layoutInflater)
    setContentView(binding.root)

    binding.btnReg.setOnClickListener {
      val intent = Intent(applicationContext, RegistActivity::class.java)
      intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP)
      startActivity(intent)
    }
    binding.btnList.setOnClickListener {
      val intent = Intent(applicationContext, ListActivity::class.java)
      intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP)
      startActivity(intent)
    }
    binding.btnExit.setOnClickListener {
      finish()
    }
  }
}