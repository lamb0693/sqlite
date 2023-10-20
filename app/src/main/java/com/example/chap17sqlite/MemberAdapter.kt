package com.example.chap17sqlite

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MemberAdapter: RecyclerView.Adapter<MemberAdapter.ViewHolder>() {
  private var list: ArrayList<MemberDTO> = ArrayList()

  fun setList(list: ArrayList<MemberDTO>) {
    this.list = list
  }
  fun addMember(dto: MemberDTO) {
    list.add(dto)
    notifyDataSetChanged()
  }
  fun getMember(position: Int): MemberDTO {
    return list[position]
  }
  fun setMember(position: Int, dto: MemberDTO) {
    list[position] = dto
    notifyDataSetChanged()
  }
  var handler: OnMemberItemClickHandler? = null

  fun setItemClickHandler(handler: OnMemberItemClickHandler) {
    this.handler = handler
  }
  inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val textId: TextView = itemView.findViewById(R.id.tvId)
    private val textName: TextView = itemView.findViewById(R.id.tvName)
    private val textAge: TextView = itemView.findViewById(R.id.tvAge)
    private val textMobile: TextView = itemView.findViewById(R.id.tvMobile)

    init {
      itemView.setOnClickListener{
        handler?.onItemClick(this, itemView, adapterPosition)
      }
    }

    fun setItem(dto: MemberDTO) {
      textId.text = dto.id.toString()
      textName.text = dto.name
      textAge.text = dto.age.toString()
      textMobile.text = dto.mobile
    }
  }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
    val inflater = LayoutInflater.from(parent.context)
    val view = inflater.inflate(R.layout.list_row, parent, false)
    return ViewHolder(view)
  }

  override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    val dto = list[position]
    holder.setItem(dto)
  }

  override fun getItemCount(): Int {
    return list.size
  }
}