package org.example.project.Screens.BookList

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.koin.compose.viewmodel.koinViewModel


@Composable
fun BookListScreen(
    viewModel: BookListViewModel = koinViewModel()
){


    LazyColumn(modifier = Modifier
        .padding(top = 80.dp)){
        items(viewModel.books.size){ index ->
            Text(
                text = viewModel.books[index],
                modifier = Modifier
                    .padding(16.dp)
            )
            if (index < viewModel.books.size - 1) {
                HorizontalDivider(modifier = Modifier.padding(5.dp))
            }
        }
    }
}