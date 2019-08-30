package com.example.books

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class BooksRepository (private val booksDAO: BooksDAO) {

    private val allBooks: LiveData<List<Books>> = booksDAO.getAllBooks()


    fun insert(books: Books) = runBlocking{
        this.launch(Dispatchers.IO) {
            booksDAO.insert(books)
        }
    }


    fun delete(books: Books) = runBlocking{
        this.launch(Dispatchers.IO) {
            booksDAO.delete(books)
        }
    }

    fun update(books: Books) = runBlocking{
        this.launch(Dispatchers.IO) {
            booksDAO.update(books)
        }
    }

    fun getAllBooks(): LiveData<List<Books>> {
        return  allBooks
    }
}