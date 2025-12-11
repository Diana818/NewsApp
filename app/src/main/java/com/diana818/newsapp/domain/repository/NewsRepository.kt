package com.diana818.newsapp.domain.repository

import com.diana818.newsapp.data.model.Article

interface NewsRepository {
    // Defines a function to get news articles
    suspend fun getTopHeadlines(
        country: String,
        category: String?,
        query: String?
    ): List<Article>
}