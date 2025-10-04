package org.example.project.Screens.BookList

import androidx.lifecycle.ViewModel

class BookListViewModel(): ViewModel() {

    var books = mutableListOf<String>()

    init {
        for(i in 1..100){
            books.add("Book $i")
        }
    }


}