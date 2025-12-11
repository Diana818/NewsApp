package com.diana818.newsapp.presentation.news_list

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewsListScreen(
    viewModel: NewsListViewModel = hiltViewModel()
) {
    // Collects the StateFlow from the ViewModel as Compose state
    val state by viewModel.state.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Top Headlines") })
        }
    ) { paddingValues ->
        Box(modifier = Modifier.fillMaxSize().padding(paddingValues)) {

            // 1. Handle Loading State
            if (state.isLoading) {
                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            }

            // 2. Handle Error State
            if (state.error != null) {
                Text(
                    text = state.error,
                    modifier = Modifier.align(Alignment.Center)
                )
            }

            // 3. Display Data List
            LazyColumn(modifier = Modifier.fillMaxSize()) {
                items(state.articles) { article ->
                    // Calls the composable for a single news item
                    NewsListItem(article = article, onClick = {
                        // TODO: Implement navigation to details screen (Part 2)
                    })
                }
            }
        }
    }
}