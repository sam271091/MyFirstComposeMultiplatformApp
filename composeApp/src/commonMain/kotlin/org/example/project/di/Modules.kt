package org.example.project.di

import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import org.example.project.Screens.BookList.BookListViewModel
import org.example.project.core.data.HttpClientFactory
import org.example.project.database.DatabaseFactory
//import org.example.project.database.DatabaseFactory
import org.example.project.database.FavoriteBookDatabase
import org.example.project.network.KtorRemoteBookDataSource
import org.example.project.network.RemoteBookDataSource
import org.example.project.repository.BookRepository
import org.example.project.repository.DefaultBookRepository
import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.bind
import org.koin.dsl.module


expect val platformModule: Module

val sharedModule = module {
    single { HttpClientFactory.create(get()) }
    singleOf(::KtorRemoteBookDataSource).bind<RemoteBookDataSource>()
    singleOf(::DefaultBookRepository).bind<BookRepository>()

    single {
        get<DatabaseFactory>().create()
            .setDriver(BundledSQLiteDriver())
            .build()
    }
    single { get<FavoriteBookDatabase>().favoriteBookDao }

    viewModelOf(::BookListViewModel)
//    viewModelOf(::BookDetailViewModel)
//    viewModelOf(::SelectedBookViewModel)
}