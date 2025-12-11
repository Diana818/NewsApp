package com.diana818.newsapp.presentation.news_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.diana818.newsapp.domain.repository.NewsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsListViewModel @Inject constructor(
    private val repository: NewsRepository
) : ViewModel() {

    // MutableStateFlow holds the current state and allows updates
    private val _state = MutableStateFlow(NewsListState())
    // StateFlow exposes the immutable state to the Composable UI
    val state: StateFlow<NewsListState> = _state.asStateFlow()

    init {
        // Fetch news when the ViewModel is first created
        fetchNews()
    }

    // Function to fetch news, which will be triggered by init or pull-to-refresh
    fun fetchNews(
        country: String = "us",
        category: String? = null,
        query: String? = null
    ) {
        viewModelScope.launch {
            // 1. Set loading state
            _state.update { it.copy(isLoading = true, error = null) }

            try {
                // 2. Call the repository to get data
                val articles = repository.getTopHeadlines(country, category, query)

                // 3. Update state with data
                _state.update {
                    it.copy(
                        articles = articles,
                        isLoading = false
                    )
                }
            } catch (e: Exception) {
                // 4. Update state with error if call fails
                _state.update {
                    it.copy(
                        error = "Failed to load news: ${e.message}",
                        isLoading = false
                    )
                }
            }
        }
    }
}