package com.example.books

import androidx.lifecycle.LiveData
import androidx.room.*
import androidx.room.OnConflictStrategy.REPLACE

@Dao
interface BooksDAO {

    @Query("SELECT * FROM Books ORDER BY _name ASC")
    fun getAllBooks(): LiveData<List<Books>>

    @Query("SELECT * FROM Books WHERE _year <= :minYear")
    fun loadBooksOlderThan(minYear:Int):List<Books>

    @Query("DELETE from Books")
    fun deleteAll()

    @Insert(onConflict = REPLACE)
    suspend fun insert(booksEntity:Books)

    @Update
    suspend fun update(vararg booksEnity: Books)

    @Delete
    suspend fun delete(vararg booksEntity: Books)


}