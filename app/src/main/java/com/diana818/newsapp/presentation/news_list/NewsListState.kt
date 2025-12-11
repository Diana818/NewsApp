package com.diana818.newsapp.presentation.news_list

import com.diana818.newsapp.data.model.Article

// Represents the complete UI state for the news list screen
data class NewsListState(
    val isLoading: Boolean = false,
    val articles: List<Article> = emptyList(),
    val error: String? = null
)