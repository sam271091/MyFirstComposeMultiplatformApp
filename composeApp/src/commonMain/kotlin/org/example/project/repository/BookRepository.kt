package org.example.project.repository

import org.example.project.core.domain.DataError
import org.example.project.core.domain.EmptyResult
import org.example.project.core.domain.Result
import kotlinx.coroutines.flow.Flow
import org.example.project.pojo.Book

interface BookRepository {
    suspend fun searchBooks(query: String): Result<List<Book>, DataError.Remote>
//    suspend fun getBookDescription(bookId: String): Result<String?, DataError>
//
//    fun getFavoriteBooks(): Flow<List<Book>>
//    fun isBookFavorite(id: String): Flow<Boolean>
//    suspend fun markAsFavorite(book: Book): EmptyResult<DataError.Local>
//    suspend fun deleteFromFavorites(id: String)
}