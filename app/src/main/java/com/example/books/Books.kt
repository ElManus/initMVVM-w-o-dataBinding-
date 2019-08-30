package com.example.books

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Books")
data class Books (@PrimaryKey(autoGenerate = true) val id: Long?,
                  @ColumnInfo(name = "_name") var name: String,
                  @ColumnInfo(name = "_author") var author: String?,
                  @ColumnInfo(name = "_year") var year: Int?,
                  @ColumnInfo(name = "_genre") var genre: String?)