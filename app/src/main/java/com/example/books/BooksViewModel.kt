package com.example.books

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData

class BooksViewModel(application: Application) : AndroidViewModel(application){
    private val repository: BooksRepository
    private val allBooks:LiveData<List<Books>>

    init {
        val booksDao = BooksDatabase.getDatabase(application).booksDao();
        repository = BooksRepository(booksDao)
        allBooks = repository.getAllBooks()
    }

     fun insert(books: Books){
        repository.insert(books)
    }

     fun delete(books: Books){
        repository.delete(books)
    }

     fun update(books: Books){
        repository.update(books)
    }

    fun getAllBooks():LiveData<List<Books>>{
        return allBooks
    }
}
