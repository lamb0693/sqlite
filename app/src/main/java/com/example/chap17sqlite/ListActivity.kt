package com.example.chap17sqlite

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.chap17sqlite.databinding.ActivityListBinding

class ListActivity : AppCompatActivity() {
  lateinit var binding: ActivityListBinding
  lateinit var adapter: MemberAdapter
  lateinit var handler: DatabaseSqlHandler

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityListBinding.inflate(layoutInflater)
    setContentView(binding.root)

    handler = DatabaseSqlHandler.open(applicationContext)
    adapter = MemberAdapter()
    adapter.handler = object : OnMemberItemClickHandler{
      override fun onItemClick(holder: MemberAdapter.ViewHolder, v: View, idx: Int) {
        val dto = adapter.getMember(idx)
        val intent = Intent(applicationContext, DetailActivity::class.java)
        intent.putExtra("member", dto)
        startActivity(intent)
      }
    }
    binding.recycler.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
    adapter.setList(handler.getList())
    binding.recycler.adapter = adapter
  }
  override fun onStart() {
    super.onStart()
    adapter.setList(handler.getList())
    adapter.notifyDataSetChanged()
  }
}