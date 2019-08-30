package com.example.books

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Books::class), version = 1)
abstract class BooksDatabase: RoomDatabase() {

    abstract fun booksDao(): BooksDAO

    companion object {
        //volatile-переменная может изменяться разными потоками. Получается, все потоки будут видеть
        //текущее значение переменной, даже если один из потоков её поменял недавно.
        @Volatile
        private var INSTANCE: BooksDatabase? = null

        fun getDatabase(context: Context): BooksDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            /*
            synchronized гарантирует
             */
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    BooksDatabase::class.java,
                    "Word_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }

    }
}