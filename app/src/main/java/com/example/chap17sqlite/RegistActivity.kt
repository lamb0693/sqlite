package com.example.chap17sqlite

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import com.example.chap17sqlite.databinding.ActivityMainBinding
import com.example.chap17sqlite.databinding.ActivityRegistBinding
import kotlin.math.log

class RegistActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_regist)
    val edName = findViewById<EditText>(R.id.edName)
    val edAge = findViewById<EditText>(R.id.edAge)
    val edMobile = findViewById<EditText>(R.id.edMobile)
    val btnReg = findViewById<Button>(R.id.btnReg)
    val btnRegBack = findViewById<Button>(R.id.btnRegBack)

    val handler = DatabaseSqlHandler.open(applicationContext)
    btnReg.setOnClickListener {
      val dto = MemberDTO(
        edName.text.toString(),
        edAge.text.toString().toInt(),
        edMobile.text.toString()
      )
      val cnt = handler.insert(dto)
      Log.d(">>", cnt.toString())
      finish()
      val intent = Intent(applicationContext, ListActivity::class.java)
      intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP)
      startActivity(intent)
    }
    btnRegBack.setOnClickListener {
      finish()
    }
  }
}