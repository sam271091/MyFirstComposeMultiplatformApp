package org.example.project.network

import org.example.project.core.domain.DataError
import org.example.project.dto.BookWorkDto
import org.example.project.dto.SearchResponseDto
import org.example.project.core.domain.Result

interface RemoteBookDataSource {
    suspend fun searchBooks(
        query: String,
        resultLimit: Int? = null
    ): Result<SearchResponseDto, DataError.Remote>

    suspend fun getBookDetails(bookWorkId: String): Result<BookWorkDto, DataError.Remote>
}