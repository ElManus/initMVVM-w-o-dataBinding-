package com.example.books

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: BooksViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //viewModel init
        viewModel = ViewModelProviders.of(this).get(BooksViewModel::class.java)

        //test object
        val obj = Books(11, "Stern", "King", 2019, "Horror")
        viewModel.insert(obj)

        /*
        подписка на данные
         */
        viewModel.getAllBooks().observe(this, Observer {
           //Update UI
          message.text = it[0].name
        })



    }


}
