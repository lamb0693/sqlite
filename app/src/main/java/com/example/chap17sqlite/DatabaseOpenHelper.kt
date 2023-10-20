package com.example.chap17sqlite

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

// SQLiteOpenHelper: db를 열고, table을 생성,검색하기 위한 객체
// 생성자를 통해서 db를 생성
class DatabaseOpenHelper(
  context: Context?,
  name: String?,
  factory: SQLiteDatabase.CursorFactory?,
  version: Int
) : SQLiteOpenHelper(context, name, factory, version) {

  // 기본 table을 생성
  override fun onCreate(db: SQLiteDatabase) {
    db.execSQL(
      "create table if not exists member " +
          "( _id integer primary key autoincrement, name text, " +
          "age integer, mobile text)"
    )
  }

  override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
    if (oldVersion != newVersion) {
      db.execSQL("drop table if exists member ")
      onCreate(db)
    }
  }
}