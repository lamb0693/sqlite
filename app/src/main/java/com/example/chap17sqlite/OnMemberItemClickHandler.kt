package com.example.chap17sqlite

import android.view.View

interface OnMemberItemClickHandler {
  fun onItemClick(holder: MemberAdapter.ViewHolder, v: View, idx: Int)
}