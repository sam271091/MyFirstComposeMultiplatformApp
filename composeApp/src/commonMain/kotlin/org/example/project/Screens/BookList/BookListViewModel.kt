package org.example.project.Screens.BookList

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import org.example.project.core.domain.onError
import org.example.project.core.domain.onSuccess
import org.example.project.repository.BookRepository

class BookListViewModel(
    private val bookRepository: BookRepository
): ViewModel() {

    var books = mutableStateListOf<String>()

    init {
//        for(i in 1..100){
//            books.add("Book $i")
//        }

        searchBooks("Kotlin")
    }


     fun searchBooks(query: String){
        viewModelScope.launch {
            bookRepository.searchBooks(query)
                .onSuccess { loadedBooks ->
                    books.clear()
                    books.addAll(loadedBooks.map { it.title }.toMutableList())
                    var a = 0
                }
                .onError { it->

                }
        }
    }

}