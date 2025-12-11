package com.diana818.newsapp.data.repository

import com.diana818.newsapp.data.remote.NewsApiService
import com.diana818.newsapp.domain.repository.NewsRepository
import com.diana818.newsapp.data.model.Article
import javax.inject.Inject

// This implementation resides in the data layer but implements the domain contract
class NewsRepositoryImpl @Inject constructor(
    private val apiService: NewsApiService
) : NewsRepository {

    override suspend fun getTopHeadlines(
        country: String,
        category: String?,
        query: String?
    ): List<Article> {
        // Call the API service and return only the list of articles
        return apiService.getTopHeadlines(
            country = country,
            category = category,
            query = query
        ).articles
    }
}